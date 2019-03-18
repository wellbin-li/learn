package com.lwb.learn.datastructure.sort;

import java.util.Arrays;

/**
 * 基数排序
 * <p>
 * 时间复杂度：平均O(d(r+n)) 最好O(d(rd+n)) 最差O(d(r+n))
 * 空间复杂度：O(rd+n)
 * 【说明】r代表关键字的基数，d代表长度，n代表关键字的个数
 * <p>
 * 思路：
 * <p>
 * 稳定
 */
public class RadixSort {

    public static void radixSort(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) { //寻找序列中的最大数
            if (a[i] > max) max = a[i];
        }
        int maxDigit = 1;
        while (max / 10 > 0) {  //确定最大数的位数
            maxDigit++;
            max /= 10;
        }

        //申请一个桶空间
        int[][] buckets = new int[10][a.length];
        int base = 10;

        //从低位到高位，对每一位遍历，将所有元素分配到桶中
        for (int i = 0; i < maxDigit; i++) {
            int[] bktLen = new int[10];        //存储各个桶中存储元素的数量

            //分配：将所有元素分配到桶中
            for (int j = 0; j < a.length; j++) {
                int whichBucket = (a[j] % base) / (base / 10);
                buckets[whichBucket][bktLen[whichBucket]] = a[j];
                bktLen[whichBucket]++;
            }

            //收集：将不同桶里数据挨个捞出来,为下一轮高位排序做准备,由于靠近桶底的元素排名靠前,因此从桶底先捞
            int k = 0;
            for (int b = 0; b < buckets.length; b++) {
                for (int p = 0; p < bktLen[b]; p++) {
                    a[k++] = buckets[b][p];
                }
            }
            System.out.println("Sorting: " + Arrays.toString(a));
            base *= 10;
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 3, 8, 4, 2, 1, 20};
        radixSort(a);
        System.out.println(Arrays.toString(a));
    }
}
