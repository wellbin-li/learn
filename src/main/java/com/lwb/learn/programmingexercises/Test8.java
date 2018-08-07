package com.lwb.learn.programmingexercises;

/**
 * 跳台阶
 *
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Test8 {

    public int JumpFloor(int target) {
        int a = 1;
        int b = 1;
        int c = -1;
        if (target == 1) {
            return 1;
        }
        int i = 1;
        while (i < target) {
            c = a + b;
            a = b;
            b = c;
            i++;
        }
        return c;
    }
}
