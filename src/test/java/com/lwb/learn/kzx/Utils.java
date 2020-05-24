package com.lwb.learn.kzx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * 工具类
 *
 * @Author: liwenbin
 * @Date: 2019/05/08
 */
public class Utils {

    //double类型格式化为0.00
    private static DecimalFormat df = new DecimalFormat("######0.00");

    /**
     * 创建name
     *
     * @return 随机四个英文字符
     */
    public static String constructName() {
        StringBuilder sb = new StringBuilder();
        sb.append((char) ('a' + Math.random() * 26))
                .append((char) ('a' + Math.random() * 26))
                .append((char) ('a' + Math.random() * 26))
                .append((char) ('a' + Math.random() * 26));
        return sb.toString();
    }

    /**
     * 创建age
     *
     * @return 18~60岁随机数
     */
    public static Integer constructAge() {
        return (int) (18 + 42 * Math.random());
    }

    /**
     * 创建salary
     *
     * @return 2000~10000随机数
     */
    public static Double constructSalary() {
        double salary = 2000 + 8000 * Math.random();
        return Double.valueOf(df.format(salary));
    }

    /**
     * 对Employee数组进行堆排序(按salary从大到小)
     *
     * @param a
     */
    public static void heapSortForEmployeeArray(Employee[] a) {
        int len = a.length - 1;
        for (int i = len / 2 - 1; i >= 0; i--) {  //堆构造（从有孩子的节点开始）
            adustHeap(a, i, len);
        }
        while (len >= 0) {
            swap(a, 0, len--);  //将堆顶元素与尾节点交换后，长度减1，尾元素最小
            adustHeap(a, 0, len);  //再次对堆进行调整（根节点）
        }
    }

    /**
     * 调整堆
     *
     * @param a      Employee数组
     * @param i      调整的开始节点
     * @param length 需要调整的数组的长度
     */
    public static void adustHeap(Employee[] a, int i, int length) {
        int left, right, j;
        while ((left = 2 * i + 1) <= length) {  //判断当前父节点有无左节点（即有无孩子节点，left为左节点）
            right = left + 1;  //右节点
            j = left;  //j指向左节点
            if (j < length && a[j].getSalary() > a[right].getSalary()) {  //右节点小于左节点
                j = right;  //j指向右节点
            }
            if (a[j].getSalary() < a[i].getSalary()) {  //将父节点与j指向的孩子节点交换
                swap(a, i, j);
            } else {   //说明比孩子节点都大，直接跳出循环语句
                break;
            }
            i = j;  //交换后考虑到对子树的影响，将i指向交换后的孩子节点，再次调整
        }
    }

    /**
     * 交换Employee数组中下标为i、j的位置
     *
     * @param a Employee数组
     * @param i
     * @param j
     */
    public static void swap(Employee[] a, int i, int j) {
        Employee temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 读取给定路径文件中的内容，以空格split
     *
     * @param path
     * @return String数组
     * @throws IOException
     */
    public static String[] readFileStringArray(String path) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader(path));
        StringBuilder sb_a = new StringBuilder();
        String line = "";
        while ((line = read.readLine()) != null) {
            sb_a.append(line + " ");
        }
        read.close();
        return sb_a.toString().split(" ");
    }
}
