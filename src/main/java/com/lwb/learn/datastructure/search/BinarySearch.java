package com.lwb.learn.datastructure.search;

/**
 * 二分查找
 * 平均查找长度≈lg(n+1)-1
 * 时间复杂度： O(log2n)
 */
public class BinarySearch {

    public static int binarySearch(int target, int[] a) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 2;
            if (target == a[mid]) {
                return mid;
            } else if (target < a[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5, 6, 7, 8, 10};
        System.out.println(binarySearch(5, a));
    }
}
