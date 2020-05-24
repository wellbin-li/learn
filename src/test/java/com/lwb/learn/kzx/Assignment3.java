package com.lwb.learn.kzx;

import java.io.*;

/**
 * 任务3：读取文件a.txt和文件b.txt中的单词，将其交替合并到文件c.txt中
 *
 * @Author: liwenbin
 * @Date: 2019/05/08
 */
public class Assignment3 {

    private static String path_a = "D://a.txt"; //文件a.txt的路径
    private static String path_b = "D://b.txt"; //文件b.txt的路径
    private static String path_c = "D://c.txt"; //文件c.txt的路径

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis(); //计时开始
        BufferedWriter write_c = new BufferedWriter(new FileWriter(path_c));
        String[] arr_a = Utils.readFileStringArray(path_a);
        String[] arr_b = Utils.readFileStringArray(path_b);
        int i;
        if (arr_a.length < arr_b.length) {  //若arr_a的长度比arr_b的长度小，则先按arr_a的长度交换写入c.txt,最后将剩下的arr_b写入c.txt
            for (i = 0; i < arr_a.length; i++) {
                write_c.write(arr_a[i] + " ");
                write_c.write(arr_b[i] + " ");
            }
            for (; i < arr_b.length; i++) {
                write_c.write(arr_b[i] + " ");
            }
        } else { //若arr_a的长度大于或arr_b的长度，则按arr_b的长度交换写入c.txt,若最后还剩余arr_a没写，则将剩下的arr_a写入c.txt
            for (i = 0; i < arr_b.length; i++) {
                write_c.write(arr_a[i] + " ");
                write_c.write(arr_b[i] + " ");
            }
            for (; i < arr_a.length; i++) {
                write_c.write(arr_a[i] + " ");
            }
        }
        write_c.flush();  //刷新缓存
        write_c.close();  //关闭流
        System.out.println("耗时：" + (System.currentTimeMillis() - start)); //整个过程耗时
    }

}
