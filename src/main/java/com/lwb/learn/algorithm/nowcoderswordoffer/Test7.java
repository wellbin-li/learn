package com.lwb.learn.algorithm.nowcoderswordoffer;

/**
 * 题目7：斐波那契数列
 * <p>
 * 题目描述：
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class Test7 {
    /**
     * 思路一：递归
     */
    public int fibonacci1(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci1(n - 1) + fibonacci1(n - 2);
        }
    }

    /**
     * 思路二：迭代
     */
    public int fibonacci2(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int f1 = 1, f2 = 1;
        int f3 = 0;
        for (int i = 3; i <= n; i++) {
            f3 = f2 + f1;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    /**
     * 思路三：动态规划
     */
    public int fibonacci3(int n) {
        int f = 0, g = 1;
        while (n-- > 0) {
            g += f;
            f = g - f;
        }
        return f;
    }
}
