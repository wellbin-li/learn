package com.lwb.learn.bigdata.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 一个Java版本的词频统计程序
 */
public class JavaWordCount {

    public static void main(String[] args) {
        //指定任务的名称
        SparkConf conf = new SparkConf();
        conf.setAppName("JavaWordCount");

        //创建SparkContext对象，是spark应用程序的入口
        JavaSparkContext context = new JavaSparkContext(conf);

        //指定以后从哪里读取数据
        JavaRDD<String> lines = context.textFile(args[0]);

        //分词压平
        JavaRDD<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String line) throws Exception {
                return Arrays.asList(line.split(" ")).iterator();
            }
        });

        //每个单词记一次数
        JavaPairRDD<String, Integer> wordAndOne = words.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<>(s, 1);
            }
        });

        //分组聚合
        JavaPairRDD<String, Integer> reduced = wordAndOne.reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer v1, Integer v2) throws Exception {
                return v1 + v2;
            }
        });

        //将key和values进行顺序颠倒（颠倒的目的是为了排序，需要根据key排序）
        JavaPairRDD<Integer, String> swaped = reduced.mapToPair(new PairFunction<Tuple2<String, Integer>, Integer, String>() {
            @Override
            public Tuple2<Integer, String> call(Tuple2<String, Integer> tp) throws Exception {
                return tp.swap();
            }
        });

        //排序
        JavaPairRDD<Integer, String> sorted = swaped.sortByKey(false);

        //将key和values进行顺序颠倒
        JavaPairRDD<String, Integer> result = sorted.mapToPair(new PairFunction<Tuple2<Integer, String>, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(Tuple2<Integer, String> tp) throws Exception {
                return tp.swap();
            }
        });

        //保存
        result.saveAsTextFile(args[1]);

        //释放资源
        context.stop();

    }
}
