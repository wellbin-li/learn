package com.lwb.learn.bigdata.hadoop.mapreduce;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * mapreduce案例：直播平台开播数据统计
 * 统计每个用户当天直播的收到金币数量，总观看pv，粉丝关注数量，视频总开播时长
 * <p>
 * 输入数据格式示例：
 * {"id":"15241919541468246679","uid":"123451","nickname":"SavageSara","gold":360,"watchnumpv":97,"watchnumuv":48,"hosts":5217,"smlook":17,"follower":2,"gifter":3,"length":2031,"area":"A_US","rating":"A","exp":54,"timestamp":1524194053}
 * {"id":"15241919541468246679","uid":"123452","nickname":"SavageSara","gold":360,"watchnumpv":97,"watchnumuv":48,"hosts":5217,"smlook":17,"follower":2,"gifter":3,"length":2031,"area":"A_US","rating":"A","exp":54,"timestamp":1524194053}
 * {"id":"15241919541468246679","uid":"123453","nickname":"SavageSara","gold":360,"watchnumpv":97,"watchnumuv":48,"hosts":5217,"smlook":17,"follower":2,"gifter":3,"length":2031,"area":"A_US","rating":"A","exp":54,"timestamp":1524194053}
 * {"id":"15241919541468246679","uid":"123454","nickname":"SavageSara","gold":360,"watchnumpv":97,"watchnumuv":48,"hosts":5217,"smlook":17,"follower":2,"gifter":3,"length":2031,"area":"A_US","rating":"A","exp":54,"timestamp":1524194053}
 * {"id":"15241919541468246679","uid":"123455","nickname":"SavageSara","gold":360,"watchnumpv":97,"watchnumuv":48,"hosts":5217,"smlook":17,"follower":2,"gifter":3,"length":2031,"area":"A_US","rating":"A","exp":54,"timestamp":1524194053}
 * {"id":"15241919541468246679","uid":"123456","nickname":"SavageSara","gold":360,"watchnumpv":97,"watchnumuv":48,"hosts":5217,"smlook":17,"follower":2,"gifter":3,"length":2031,"area":"A_US","rating":"A","exp":54,"timestamp":1524194053}
 * {"id":"15241919541468246679","uid":"123457","nickname":"SavageSara","gold":360,"watchnumpv":97,"watchnumuv":48,"hosts":5217,"smlook":17,"follower":2,"gifter":3,"length":2031,"area":"A_US","rating":"A","exp":54,"timestamp":1524194053}
 * {"id":"15241919541468246679","uid":"123458","nickname":"SavageSara","gold":360,"watchnumpv":97,"watchnumuv":48,"hosts":5217,"smlook":17,"follower":2,"gifter":3,"length":2031,"area":"A_US","rating":"A","exp":54,"timestamp":1524194053}
 * {"id":"15241919541468246679","uid":"123459","nickname":"SavageSara","gold":360,"watchnumpv":97,"watchnumuv":48,"hosts":5217,"smlook":17,"follower":2,"gifter":3,"length":2031,"area":"A_US","rating":"A","exp":54,"timestamp":1524194053}
 * {"id":"15241919541468246679","uid":"1234510","nickname":"SavageSara","gold":360,"watchnumpv":97,"watchnumuv":48,"hosts":5217,"smlook":17,"follower":2,"gifter":3,"length":2031,"area":"A_US","rating":"A","exp":54,"timestamp":1524194053}
 * {"id":"15241919541468246679","uid":"123456","nickname":"SavageSara","gold":360,"watchnumpv":97,"watchnumuv":48,"hosts":5217,"smlook":17,"follower":2,"gifter":3,"length":2031,"area":"A_US","rating":"A","exp":54,"timestamp":1524194053}
 * {"id":"15241919541468246679","uid":"123456","nickname":"SavageSara","gold":360,"watchnumpv":97,"watchnumuv":48,"hosts":5217,"smlook":17,"follower":2,"gifter":3,"length":2031,"area":"A_US","rating":"A","exp":54,"timestamp":1524194053}
 * {"id":"15241919541468246679","uid":"1234510","nickname":"SavageSara","gold":360,"watchnumpv":97,"watchnumuv":48,"hosts":5217,"smlook":17,"follower":2,"gifter":3,"length":2031,"area":"A_US","rating":"A","exp":54,"timestamp":1524194053}
 * <p>
 * 说明：
 * {'id':'视频id','uid:'主播id','nickname':'主播nickname','gold':'视频金币数据','watchnumpv':'视频观看人数pv','watchnumuv':'视频观看人数uv','hots':'视频点赞数','smlook':'进入直播间大于20秒人数','follower':'关注数','gifter':'送礼人数uv','length':'视频时长','area':'视频分区','rating':'评级','exp':'经验','timestamp':视频结束时间}
 * 需要自定义数据类型-VideoInfoWritable
 * <p>
 * 输出示例:
 * 123451  360     97      2       2031
 * 1234510 720     194     4       4062
 * 123452  360     97      2       2031
 * 123453  360     97      2       2031
 * 123454  360     97      2       2031
 * 123455  360     97      2       2031
 * 123456  1080    291     6       6093
 * 123457  360     97      2       2031
 * 123458  360     97      2       2031
 * 123459  360     97      2       2031
 */
public class AnchorVideo {

    public static class AnchorVideoMapper extends Mapper<LongWritable, Text, Text, VideoInfoWritable> {
        Text k2 = new Text();
        VideoInfoWritable v2 = new VideoInfoWritable();

        @Override
        protected void map(LongWritable k1, Text v1, Context context) throws IOException, InterruptedException {
            String line = v1.toString();
            JSONObject jsonObj = JSON.parseObject(line);
            k2.set(jsonObj.getString("uid"));
            v2.set(jsonObj.getLong("gold"), jsonObj.getLong("watchnumpv"), jsonObj.getLong("follower"), jsonObj.getLong("length"));
            context.write(k2, v2);
        }
    }

    public static class AnchorVideoReducer extends Reducer<Text, VideoInfoWritable, Text, VideoInfoWritable> {
        VideoInfoWritable v3 = new VideoInfoWritable();

        @Override
        protected void reduce(Text k2, Iterable<VideoInfoWritable> v2s, Context context) throws IOException, InterruptedException {
            long gold = 0L;
            long watchnumpv = 0L;
            long follower = 0L;
            long length = 0L;
            for (VideoInfoWritable v2 : v2s) {
                gold += v2.getGold();
                watchnumpv += v2.getWatchnumpv();
                follower += v2.getFollower();
                length += v2.getLength();
            }
            v3.set(gold, watchnumpv, follower, length);
            context.write(k2, v3);
        }
    }

    public static class VideoInfoWritable implements Writable {

        private Long gold;
        private Long watchnumpv;
        private Long follower;
        private Long length;

        public void set(Long gold, Long watchnumpv, Long follower, Long length) {
            this.gold = gold;
            this.watchnumpv = watchnumpv;
            this.follower = follower;
            this.length = length;
        }

        public Long getGold() {
            return gold;
        }

        public Long getWatchnumpv() {
            return watchnumpv;
        }

        public Long getFollower() {
            return follower;
        }

        public Long getLength() {
            return length;
        }

        @Override
        public void write(DataOutput out) throws IOException {
            out.writeLong(gold);
            out.writeLong(watchnumpv);
            out.writeLong(follower);
            out.writeLong(length);
        }

        @Override
        public void readFields(DataInput in) throws IOException {
            this.gold = in.readLong();
            this.watchnumpv = in.readLong();
            this.follower = in.readLong();
            this.length = in.readLong();
        }

        @Override
        public String toString() {
            return gold + "\t" + watchnumpv + "\t" + follower + "\t" + length;
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.exit(10);
        }
        //获取输入、输出目录
        String inputPath = args[0];
        //输出目录一定是不存在的目录
        String outputPath = args[1];
        //获取配置类
        Configuration conf = new Configuration();
        //获取job名称
        String jobName = AnchorVideo.class.getSimpleName();
        Job job = Job.getInstance(conf, jobName);
        //组装jar包必备代码
        job.setJarByClass(AnchorVideo.class);
        //设置输入文件目录
        FileInputFormat.setInputPaths(job, inputPath);
        //设置输出文件目录
        FileOutputFormat.setOutputPath(job, new Path(outputPath));
        //设置map相关参数
        job.setMapperClass(AnchorVideoMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(VideoInfoWritable.class);
        //设置reduce相关参数
        job.setReducerClass(AnchorVideoReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(VideoInfoWritable.class);
        //提交job，等待任务完成
        job.waitForCompletion(true);
    }
}
