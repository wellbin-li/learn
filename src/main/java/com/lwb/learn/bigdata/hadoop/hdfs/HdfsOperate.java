package com.lwb.learn.bigdata.hadoop.hdfs;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.FileInputStream;

/**
 * hdfs操作
 */
public class HdfsOperate {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://192.168.80.150:9000");
        conf.set("dfs.permissions", "false");
        FileSystem fs = FileSystem.get(conf);
        //上传文件
        put(fs);
    }

    /**
     * 上传文件
     * 注意windows直接操作hdfs没有权限，方案：
     * 1、关闭hdfs的权限验证，在hdfs-site.xml中添加：
     * <property>
     * <name>dfs.permissions.enabled</name>
     * <value>true</value>
     * </property>
     * 2、将代码放到linux上执行
     *
     * @param fs
     * @throws Exception
     */
    public static void put(FileSystem fs) throws Exception {
        //上传hdfs位置
        Path path = new Path("hdfs://192.168.80.150:9000/WordCount1.jar");
        //从文件系统获取输出流
        FSDataOutputStream outPut = fs.create(path);
        //获取本地客户端的输入流
        FileInputStream inPut = new FileInputStream("d:\\WordCount1.jar");
        //通过工具将输入流复制到输出流，达到上传文件的目的
        IOUtils.copy(inPut, outPut);
    }
}
