package com.lwb.learn.datastructure.sort;

import org.springframework.beans.factory.Aware;

import java.util.Arrays;

/**
 * 堆排序
 * 时间复杂度：平均O(n*log2n) 最好O(n*log2n) 最差O(n*log2n)
 * 空间复杂度：辅助存储O(1)
 * 不稳定
 */
public class HeapSort {

    public static void heapSort(int[] a) {
        int len = a.length - 1;
        for (int i = len / 2 - 1; i >= 0; i--) {  //堆构造（从有孩子的节点开始）
            adustHeap(a, i, len);
        }
        while (len >= 0) {
            swap(a, 0, len--);  //将堆顶元素与尾节点交换后，长度减1，尾元素最大
            adustHeap(a, 0, len);  //再次对堆进行调整（根节点）
        }
    }

    /**
     * 调整堆
     *
     * @param a      需要调整的数组
     * @param i      调整的开始节点
     * @param length 需要调整的数组的长度
     */
    public static void adustHeap(int[] a, int i, int length) {
        int left, right, j;
        while ((left = 2 * i + 1) <= length) {  //判断当前父节点有无左节点（即有无孩子节点，left为左节点）
            right = left + 1;  //右节点
            j = left;  //j指向左节点
            if (j < length && a[j] < a[right]) {  //右节点大于左节点
                j = right;  //j指向右节点
            }
            if (a[j] > a[i]) {  //将父节点与j指向的孩子节点交换
                swap(a, i, j);
            } else {   //说明比孩子节点都大，直接跳出循环语句
                break;
            }
            i = j;  //交换后考虑到对子树的影响，将i指向交换后的孩子节点，再次调整
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {20, 50, 20, 40, 70, 10, 80, 30, 60};
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }
}
