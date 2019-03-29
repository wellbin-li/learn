package com.lwb.learn.bigdata.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;

/**
 * 使用JavaLambda实现词频统计
 */
public class JavaLambdaWC {

    public static void main(String[] args) {
        //指定任务的名称
        SparkConf conf = new SparkConf();
        conf.setAppName("JavaLambdaWC");

        //创建SparkContext对象，是spark应用程序的入口
        JavaSparkContext context = new JavaSparkContext(conf);

        //指定以后从哪里读取数据
        JavaRDD<String> lines = context.textFile(args[0]);

        //分词压平
        JavaRDD<String> words = lines.flatMap(line -> Arrays.asList(line.split(" ")).iterator());

        //每个单词记一次数
        JavaPairRDD<String, Integer> wordAndOne = words.mapToPair(s -> new Tuple2<>(s, 1));

        //分组聚合
        JavaPairRDD<String, Integer> reduced = wordAndOne.reduceByKey((x, y) -> x + y);

        //将key和values进行顺序颠倒（颠倒的目的是为了排序，需要根据key排序）
        JavaPairRDD<Integer, String> swaped = reduced.mapToPair(tp -> tp.swap());

        //排序
        JavaPairRDD<Integer, String> sorted = swaped.sortByKey(false);

        //将key和values进行顺序颠倒
        JavaPairRDD<String, Integer> result = sorted.mapToPair(tp -> tp.swap());

        //保存
        result.saveAsTextFile(args[1]);

        //释放资源
        context.stop();
    }
}
