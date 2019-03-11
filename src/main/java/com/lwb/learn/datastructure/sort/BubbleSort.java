package com.lwb.learn.datastructure.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 时间复杂度：平均O(n^2)  最好O(n)(针对改进版)：有序  最差O(n^2):逆序
 * 空间复杂度：辅助存储O(1)
 * 稳定
 */
public class BubbleSort {

    //冒泡排序
    public static int[] bubbleSort1(int[] a) {
        int n = a.length;
        int i, j, temp;
        for (i = 1; i < a.length; i++) {
            for (j = 0; j < n - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

    //冒泡排序改进版
    public static int[] bubbleSort2(int[] a) {
        int n = a.length;
        int flag, i, j, temp;
        for (i = 1; i < a.length; i++) {
            flag = 0;
            for (j = 0; j < n - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = 1; // 若发生变换，则标记为1
                }
            }
            if (flag == 0) {
                break; // 若没发生交换，则说明数列已有序，跳出循环。
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 6, 9, 1, 4, 7};
        int[] b = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(bubbleSort1(a)));
        System.out.println(Arrays.toString(bubbleSort2(b)));
    }
}

