package com.lwb.learn.algorithm.nowcoderswordoffer;

/**
 * 题目6：旋转数组的最小数字
 * <p>
 * 题目描述：
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元
 * 素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Test6 {
    /**
     * 思路一：顺序遍历
     */
    public int minNumberInRotateArray1(int[] array) {
        if (array.length == 0) return 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return array[i];
            }
        }
        return array[0];
    }

    /**
     * 思路二：二分查找的改进
     */
    public int minNumberInRotateArray2(int[] array) {
        if (array.length == 0) return 0;
        int low = 0;
        int high = array.length - 1;
        int mid = -1;
        while (array[low] >= array[high]) {
            if (high - low == 1) {
                mid = high;
                break;
            }
            mid = low + (high - low) / 2;
            if (array[mid] >= array[low]) low = mid;
            if (array[mid] <= array[high]) high = mid;
        }
        return array[mid];
    }
}
