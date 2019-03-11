package com.lwb.learn.datastructure.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 时间复杂度：平均O(n^2)  最好O(n^2)  最差O(n^2)
 * 空间复杂度：辅助存储O(1)
 * 不稳定 如：{5, 8, 5, 2, 9}
 */
public class SelectSort {

    public static int[] selectSort(int[] a) {
        int n = a.length;
        int i, j, min, temp;
        for (i = 0; i < n - 1; i++) {
            min = i;
            for (j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (min != i) {
                temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 6, 9, 1, 4, 7};
        System.out.println(Arrays.toString(selectSort(a)));
    }
}