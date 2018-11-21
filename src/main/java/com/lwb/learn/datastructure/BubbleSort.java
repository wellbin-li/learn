package com.lwb.learn.datastructure;

/**
 * 冒泡排序
 * 时间复杂度：平均O(n2)  最好O(n)：有序  最差O(n2):逆序
 * 空间复杂度：辅助存储O(1)
 * 稳定
 */
public class BubbleSort {

    //冒泡排序
    public static void bubbleSort1(int[] a) {
        int n = a.length;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < n - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    //冒泡排序改进版
    public static void bubbleSort2(int[] a) {
        int n = a.length;
        int flag;
        for (int i = 1; i < a.length; i++) {
            flag = 0;
            for (int j = 0; j < n - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = 1; // 若发生变换，则标记为1
                }
            }
            if(flag ==0){
                break; // 若没发生交换，则说明数列已有序，跳出循环。
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 6, 9, 1, 4, 7};
        int[] b = {1, 2, 3, 4, 5, 6, 7};
//        bubbleSort1(a);
//        bubbleSort1(b);
//        bubbleSort2(a);
        bubbleSort2(b);
    }
}

