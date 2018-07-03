package scu.pxbd.flowplus;

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

/**
 * 在第一题中将归并好的结果作为排序的输入文件
 */
public class FlowCount {
    public static class FlowCountMapper extends Mapper<LongWritable,Text,FlowBean,Text> {
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String[] rowcontent = value.toString().split("\\t");
            FlowBean flowBean = new FlowBean();
            if(rowcontent.length > 3){
                String cell = rowcontent[0];
                long up = Long.parseLong(rowcontent[1]);
                long down = Long.parseLong(rowcontent[2]);
                flowBean.set(cell,up,down);
                context.write(flowBean,new Text(cell));
            }
        }
    }
    public static class FlowCountReducer extends Reducer<FlowBean,Text,Text,FlowBean> {

        @Override
        protected void reduce(FlowBean key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            context.write(values.iterator().next(), key);
        }


    }
    public static void main(String[] args) throws Exception{
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);

        job.setNumReduceTasks(1);

        job.setJarByClass(FlowCount.class);
        job.setMapperClass(FlowCountMapper.class);
        job.setReducerClass(FlowCountReducer.class);

        job.setMapOutputKeyClass(FlowBean.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        FileInputFormat.setInputPaths(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        boolean flag = job.waitForCompletion(true);
        System.exit(flag? 1:0);
    }
}
