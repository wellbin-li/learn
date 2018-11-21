package com.lwb.learn.datastructure;

import java.util.Arrays;

/**
 * 希尔排序
 * 时间复杂度：平均O(nlog2n)  最好O(n2)
 * 空间复杂度：辅助存储O(1)
 * 不稳定
 */
public class ShellSort {

    public static void shellSort(int[] a) {
        int step = a.length / 2;
        while (step >= 1) {
            for (int i = 0; i + step < a.length; i++) {
                if (a[i] > a[i + step]) {
                    int temp = a[i];
                    a[i] = a[i + step];
                    a[i + step] = temp;
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
