package scu.pxbd.flow;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class FlowCount {

    public static class FlowCountMapper extends Mapper<LongWritable,Text,Text,Text> {
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String[] rowcontent = value.toString().split("\\t");
            String[] request = new String[3];
            if(rowcontent.length > 2){
                request[0] = rowcontent[1]; //手机号
                request[1] = rowcontent[rowcontent.length-2]; //上行流量
                request[2] = rowcontent[rowcontent.length-3]; //下行流量
                int up = Integer.parseInt(request[1]);
                int down = Integer.parseInt(request[2]);
                int count = up + down ;
                String liu = request[1] + "\t" + request[2] + "\t" + String.valueOf(count);
                context.write(new Text(request[0]),new Text(liu));

            }
        }
    }
    public static class FlowCountReducer extends Reducer<Text,Text,Text,Text>{

        @Override
        protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            int up_count = 0;
            int down_count = 0;
            int count = 0;
            for(Text value : values){
                String[] value_array = value.toString().split("\\t");
                if(value_array.length > 2){
                    up_count += Integer.parseInt(value_array[0]);
                    down_count += Integer.parseInt(value_array[1]);
                    count += Integer.parseInt(value_array[2]);
                }
            }
            String result = key.toString() + "\t" + String.valueOf(up_count)+"\t"+String.valueOf(down_count)+"\t"+String.valueOf(count);
            context.write(key,new Text(result));
        }

    }
    public static void main(String[] args) throws Exception{
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);

        job.setNumReduceTasks(1);

        job.setJarByClass(FlowCount.class);
        job.setMapperClass(FlowCountMapper.class);
        job.setReducerClass(FlowCountReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.setInputPaths(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        boolean flag = job.waitForCompletion(true);
        System.exit(flag? 1:0);
    }
}
