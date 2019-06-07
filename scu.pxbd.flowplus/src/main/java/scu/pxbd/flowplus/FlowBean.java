package scu.pxbd.flowplus;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class FlowBean implements WritableComparable<FlowBean> {
    private String cellphone; //手机号
    private long up_count;  //上行流量和
    private long down_count; //下行流量和
    private long sum_count; //总和
    public  void set(String cellphone, long up_count, long down_count){
        this.cellphone = cellphone;
        this.up_count = up_count;
        this.down_count = down_count;
        this.sum_count = up_count + down_count;
    }

    /**
     * 序列化，将数据以字节流输出
     */
    public void write(DataOutput out) throws IOException{
        out.writeUTF(cellphone);
        out.writeLong(up_count);
        out.writeLong(down_count);
        out.writeLong(sum_count);
    }

    public void readFields(DataInput in) throws  IOException{
        cellphone = in.readUTF();
        up_count = in.readLong();
        down_count = in.readLong();
        sum_count= in.readLong();
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public long getUp_count() {
        return up_count;
    }

    public void setUp_count(long up_count) {
        this.up_count = up_count;
    }

    public long getDown_count() {
        return down_count;
    }

    public void setDown_count(long down_count) {
        this.down_count = down_count;
    }

    public long getSum_count() {
        return sum_count;
    }

    public void setSum_count(long sum_count) {
        this.sum_count = sum_count;
    }

    @Override
    public String toString() {
        return up_count + "\t" + down_count + "\t" + sum_count;
    }

    //比较排序重写，以总流量为key，二次排序
    public int compareTo(FlowBean o) {
        return this.sum_count> o.getSum_count()?-1:1;
    }

}
