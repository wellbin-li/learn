package com.lwb.learn.datastructure.sort;

import java.util.Arrays;
import java.util.Stack;

/**
 * 快速排序（挖坑法，左右指针法，前后指针法），常见的就是挖坑法
 * 时间复杂度：平均O(n*log2n) 最好O(n*log2n) 最差O(n^2)
 * 空间复杂度：
 * 就地快速排序使用的空间是O(1)的，也就是个常数级；而真正消耗空间的就是递归调用了，因为每次递归就要保持一些数据；
 * 最优的情况下空间复杂度为：O(logn)  ；每一次都平分数组的情况
 * 最差的情况下空间复杂度为：O( n )      ；退化为冒泡排序的情况
 * 不稳定 如：{6，1，3，7，3}
 */
public class QuickSort {

    // 快速排序(写法一)
    public static void quickSort1(int[] a, int left, int right) {
        if (left < right) {
            int p = partition4(a, left, right);
            quickSort1(a, left, p - 1);
            quickSort1(a, p + 1, right);
        }
    }

    //分割策略1（挖坑法）
    public static int partition1(int[] a, int left, int right) {
        int key = a[left];
        while (left < right) {
            while (left < right && a[right] >= key) right--;
            a[left] = a[right];
            while (left < right && a[left] <= key) left++;
            a[right] = a[left];
        }
        a[left] = key;
        return left;
    }

    //分割策略2（在策略1基础上减少了同一位置的赋值操作）
    public static int partition2(int[] a, int left, int right) {
        int key = a[left];
        while (left < right) {
            while (left < right && a[right] >= key) right--;
            if (left < right) {
                a[left] = a[right];
                left++;
            }
            while (left < right && a[left] <= key) left++;
            if (left < right) {
                a[right] = a[left];
                right--;
            }
        }
        a[left] = key;
        return left;
    }

    //分割策略3(左右指针法)
    public static int partition3(int[] a, int left, int right) {
        int begin = left;
        int key = a[left];
        int temp;
        while (left < right) {
            while (left < right && a[right] >= key) right--;
            while (left < right && a[left] <= key) left++;
            if (left < right) {
                temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }
        }
        if (a[begin] != a[left]) {
            temp = a[begin];
            a[begin] = a[left];
            a[left] = temp;
        }
        return left;
    }

    //分割策略4(前后指针法)
    public static int partition4(int[] a, int left, int right) {
        int pre = left, cur = left + 1;
        int tmp = a[pre];
        int temp;
        while (cur <= right) {
            if (tmp > a[cur] && ++pre != cur) {
                temp = a[pre];
                a[pre] = a[cur];
                a[cur] = temp;
            }
            cur++;
        }
        a[left] = a[pre];
        a[pre] = tmp;
        return pre;
    }

    // 快速排序（写法二）
    public static void quickSort2(int[] a, int start, int end) {
        if (start < end) {
            int left = start;
            int right = end;
            int key = a[left]; //选取最左边的点
            while (left < right) {
                while (left < right && a[right] >= key) right--;
                a[left] = a[right];
                while (left < right && a[left] <= key) left++;
                a[right] = a[left];
            }
            a[left] = key;
            quickSort2(a, start, left - 1);
            quickSort2(a, right + 1, end);
        }
    }

    // 快速排序（非递归）
    public static void quickSort3(int[] a, int low, int high) {
        int pivot;
        if (low >= high)
            return;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(low);
        stack.push(high);
        while (!stack.empty()) {
            // 先弹出high,再弹出low
            high = stack.pop();
            low = stack.pop();
            pivot = partition1(a, low, high);
            // 先压low,再压high
            if (low < pivot - 1) {
                stack.push(low);
                stack.push(pivot - 1);
            }
            if (pivot + 1 < high) {
                stack.push(pivot + 1);
                stack.push(high);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 3, 8, 4, 2, 1};
        quickSort3(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
