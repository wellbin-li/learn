import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * 这是一个scala版本的词频统计
  */
object ScalaWordCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("ScalaWordCount")

    //这是spark程序的执行入口
    val sc = new SparkContext(conf)

    //通过sc指定以后数据从哪里来
    val lines: RDD[String] = sc.textFile(args(0))

    //将内容分词后压平
    val words: RDD[String] = lines.flatMap(_.split(" "))

    //将单词和1组合到一起，每个单词记一次数
    val wordAndOne: RDD[(String, Int)] = words.map((_, 1))

    //分组聚合
    val reduced: RDD[(String, Int)] = wordAndOne.reduceByKey(_ + _)

    //排序
    val sorted = reduced.sortBy(_._2, false)

    //保存结果
    sorted.saveAsTextFile(args(1))

    //释放资源
    sc.stop()
  }
}
