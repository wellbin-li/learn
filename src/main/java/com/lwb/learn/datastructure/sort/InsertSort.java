package com.lwb.learn.datastructure.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 时间复杂度：平均O(n^2)   最好O(n) ：有序  最差O(n^2)
 * 空间复杂度：辅助存储O(1)
 * 稳定
 */
public class InsertSort {

    public static int[] insertSort(int[] a) {
        int i, j, temp;
        for (i = 1; i < a.length; i++) {
            temp = a[i];
            for (j = i - 1; j >= 0 && temp < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j+1] = temp; //将比较的元素插入
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 6, 9, 1, 4, 7};
        System.out.println(Arrays.toString(insertSort(a)));
    }
}
