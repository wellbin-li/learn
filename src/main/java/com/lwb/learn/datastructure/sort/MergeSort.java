package com.lwb.learn.datastructure.sort;

import java.util.Arrays;

/**
 * 归并排序(二路)
 *
 * 时间复杂度：平均O(n*log2n) 最好O(n*log2n) 最差O(n*log2n)
 * 空间复杂度：O(1)，本例只需分配一个大的存储空间在合并的时候重复利用，若每次合并都分配存储空间的话为O(n)
 *
 * 思路：
 * 第一步：申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
 * 第二步：设定两个指针，最初位置分别为两个已经排序序列的起始位置
 * 第三步：比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
 * 重复步骤3直到某一指针超出序列尾
 * 将另一序列剩下的所有元素直接复制到合并序列尾
 *
 * 稳定
 */
public class MergeSort {

    public static void mergeSort(int[] a, int low, int high, int[] temp) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(a, low, mid, temp); //使左边序列有序
        mergeSort(a, mid + 1, high, temp); //使右边序列有序
        merge(a, low, mid, high, temp); //将两个有序序列合并
    }

    public static void merge(int[] a, int low, int mid, int high, int[] temp) {  //合并的函数
        int i = low, j = mid + 1, k = 0; //指针
        while (i <= mid && j <= high) {  //当左右两边都有数时进行比较，取较小的数
            if (a[i] <= a[j]) {
                temp[k] = a[i];
                i++;
                k++;
            } else {
                temp[k] = a[j];
                j++;
                k++;
            }
        }
        while (i <= mid) {  //如果左边序列还有数
            temp[k] = a[i];
            i++;
            k++;
        }
        while (j <= high) { //如果右边序列还有数
            temp[k] = a[j];
            j++;
            k++;
        }
        for (i = 0; i < k; i++, low++) {  //将temp当中该段有序元素赋值给a中的待排序列使之部分有序，法1
            a[low] = temp[i];
        }
        //System.arraycopy(temp, 0, a, low, k); //将temp当中该段有序元素赋值给a中的待排序列使之部分有序，法2
    }

    public static void main(String[] args) {
        int[] a = {5, 3, 8, 4, 2, 1};
        int[] temp = new int[a.length]; //分配临时空间，用于排序过程中的临时存储
        mergeSort(a, 0, a.length - 1, temp);
        System.out.println(Arrays.toString(a));
    }
}
