package com.lwb.learn.algorithm.nowcoderswordoffer;

/**
 * 题目1：二维数组中的查找
 * <p>
 * 题目描述：
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Test1 {

    /**
     * 思路一：从数组右上角开始遍历，若比目标值小，则向下；若比目标值大，则向左，直到找到或者遍历结束为止
     */
    public static boolean find1(int target, int[][] array) {
        int m = array.length - 1;
        int n = array[0].length - 1;
        int i = 0, j = n;
        while (i <= m && j >= 0) {
            if (array[i][j] == target) return true;
            if (array[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    /**
     * 思路二：遍历二维数组中的每个一维数组，对每个一维数组进行二分查找，直到找到或者遍历结束为止
     */
    public static boolean find2(int target, int[][] array) {
        int low, high, mid;
        for (int i = 0; i < array.length; i++) {
            low = 0;
            high = array[i].length - 1;
            while (low <= high) {
                mid = (low + high) / 2;
                if (array[i][mid] == target) return true;
                if (array[i][mid] < target) low = mid + 1;
                if (array[i][mid] > target) high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(find2(16, array));
    }
}
