package com.lwb.learn.bigdata.hadoop.mapreduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

/**
 * mapreduce实现单词计数
 * 输入文本样例：
 * hello    you
 * hello    me
 * 输出结果样例：
 * hello   2
 * me      1
 * you     1
 */
public class WordCount1 {

    public static class MyMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
        Text k2 = new Text();
        LongWritable v2 = new LongWritable();

        @Override
        protected void map(LongWritable k1, Text v1, Context context) throws IOException, InterruptedException {
            System.out.println("{k1:" + k1.get() + ",v1:" + v1.toString() + "}"); //输出信息可到具体执行的节点logs上查看
            String line = v1.toString();
            String[] splits = line.split("\t");
            for (String word : splits) {
                k2.set(word);
                v2.set(1);
                context.write(k2, v2);
                System.out.println("{k2:" + k2.toString() + ",v2:" + v2.get() + "}");
            }
        }
    }

    public static class MyReducer extends Reducer<Text, LongWritable, Text, LongWritable> {
        Text k3 = new Text();
        LongWritable v3 = new LongWritable();

        @Override
        protected void reduce(Text k2, Iterable<LongWritable> v2s, Context context) throws IOException, InterruptedException {
            System.out.println("{k2:" + k2.toString() + ",v2s:" + v2s.toString() + "}");
            Iterator<LongWritable> it = v2s.iterator();
            long sum = 0;
            while (it.hasNext()) {
                LongWritable next = it.next();
                long num = next.get();
                sum += num;
            }
            k3.set(k2);
            v3.set(sum);
            context.write(k3, v3);
            System.out.println("{k3:" + k3.toString() + ",v3:" + v3.get() + "}");
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
        String jobName = WordCount1.class.getSimpleName();
        Job job = Job.getInstance(conf, jobName);
        //组装jar包必备代码
        job.setJarByClass(WordCount1.class);
        //设置输入文件目录
        FileInputFormat.setInputPaths(job, inputPath);
        //设置输出文件目录
        FileOutputFormat.setOutputPath(job, new Path(outputPath));
        //设置map相关参数
        job.setMapperClass(MyMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);
        //设置reduce相关参数
        job.setReducerClass(MyReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);
        //提交job，等待任务完成
        job.waitForCompletion(true);
    }
}
