package com.lwb.learn.bigdata.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * 使用java代码操作hbase
 * <p>
 * 表的操作DDL：主要使用admin来操作
 * 数据的操作DML：主要使用table来操作
 */
public class HbaseOpe {
    public static void main(String[] args) throws IOException {
        //获取配置参数（需在resources资源文件中添加hbase-site.xml配置文件）
        Configuration conf = HBaseConfiguration.create();
        //获取hbase连接
        Connection con = ConnectionFactory.createConnection(conf);
        //获取操作表的对象
        Table table = con.getTable(TableName.valueOf("t2"));

        //putOp(table);
        //getOp(table);

        //关闭连接
        table.close();
        con.close();
    }

    /**
     * 添加数据
     *
     * @param table
     * @throws IOException
     */
    private static void putOp(Table table) throws IOException {
        byte[] rowKey = Bytes.toBytes("r3");
        Put put = new Put(rowKey); //封装put对象，代表要添加的数据
        byte[] family = Bytes.toBytes("c1");
        byte[] qualifier = Bytes.toBytes("q1");
        byte[] value = Bytes.toBytes("v1");
        put.addColumn(family, qualifier, value);
        table.put(put);
    }

    /**
     * 查询数据
     *
     * @param table
     * @throws IOException
     */
    private static void getOp(Table table) throws IOException {
        byte[] rowKey = Bytes.toBytes("r3");
        Get get = new Get(rowKey);
        Result result = table.get(get);
        byte[] family = Bytes.toBytes("c1");
        byte[] qualifier = Bytes.toBytes("q1");
        byte[] value = result.getValue(family, qualifier);
        System.out.println(Bytes.toString(value));
    }

}
