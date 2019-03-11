package com.lwb.learn.datastructure.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 时间复杂度：平均O(n^1.3)  最好O(n)  最坏O(n^2)
 * 空间复杂度：辅助存储O(1)
 * 不稳定
 */
public class ShellSort {

    public static void shellSort(int[] a) {
        int i, j;
        int step = a.length / 2;
        while (step >= 1) {
            for (int k = 0; k < step; k++) {
                for (i = k + step; i < a.length; i += step) {
                    int key = a[i];
                    for (j = i - step; j >= 0 && key < a[j]; j -= step) {
                        a[j + step] = a[j];
                    }
                    a[j + step] = key;
                }
            }
            step /= 2;
        }
    }


    public static void main(String[] args) {
        int[] a = {9, 1, 2, 5, 7, 4, 8, 6, 3, 5};
        shellSort(a);
        System.out.println(Arrays.toString(a));
    }

}
