package com.lwb.learn.datastructure;

/**
 * 快速排序
 * 下面两种方法是一样的
 * 时间复杂度：平均O(n*log2n) 最好O(n*log2n) 最差O(n2)
 * 空间复杂度： O(log2n)~O(n)
 * 不稳定
 */
public class QuickSort {

    // 快速排序一
    public static void quickSort1(int[] a, int left, int right) {
        if(left<right) {
            int p = method(a, left, right);
            quickSort1(a, left, p - 1);
            quickSort1(a, p + 1, right);
        }
    }

    public static int method(int[] a, int left, int right) {
        int key = a[left];
        while (left < right) {
            while (left < right && a[right] >= key) right--;
            if (a[right] < key) {
                a[left] = a[right];
            }
            while (left < right && a[left] <= key) left++;
            if (a[left] > key) {
                a[right] = a[left];
            }
        }
        a[left] = key;
        return left;
    }

    // 快速排序2
    public static void quickSort2(int[] a, int start, int end) {
        if(start<end){
            int left = start;
            int right = end;
            int key = a[left]; //选取最左边的点
            while (left < right) {
                while (left < right && a[right] >= key) right--;
                if (a[right] < key) {
                    a[left] = a[right];
                }
                while (left < right && a[left] <= key) left++;
                if (a[left] > key) {
                    a[right] = a[left];
                }
            }
            a[left] = key;
            quickSort2(a, start, left - 1);
            quickSort2(a, right + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 6, 9, 1, 4, 7};
        quickSort1(a, 0, a.length - 1);
        //quickSort2(a, 0, a.length - 1);
        System.out.println(a);
    }
}
