package com.lwb.learn.datastructure;

/**
 * 插入排序
 * 时间复杂度：平均O(n2)  最好O(n)：有序  最差O(n2)
 * 空间复杂度：辅助存储O(1)
 * 稳定
 */
public class InsertSort {

    public static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j;
            int temp = a[i];
            for (j = i - 1; j >= 0 && temp < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j+1] = temp; //将比较的元素插入
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 6, 9, 1, 4, 7};
        insertSort(a);
        System.out.println(a);
    }
}
