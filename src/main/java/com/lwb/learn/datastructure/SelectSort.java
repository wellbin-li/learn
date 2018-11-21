package com.lwb.learn.datastructure;

/**
 * 选择排序
 * 时间复杂度：平均O(n2)  最好O(n2)  最差O(n2)
 * 空间复杂度：辅助存储O(1)
 * 不稳定
 */
public class SelectSort {

    public static void selectSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n-1; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if(a[j]<a[min]){
                    int temp = a[min];
                    a[min] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 6, 9, 1, 4, 7};
        selectSort(a);
        System.out.println(a);
    }
}