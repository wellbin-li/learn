package com.lwb.learn.programmingexercises;

/**
 * 变态跳台阶
 *
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Test9 {

    /**
     * 方法三
     */
    public int JumpFloorII(int target) {
        return 1<<(target-1);
    }

    /**
     * 方法二
     */
//    public int JumpFloorII(int target) {
//        if(target<2){
//            return target;
//        }
//        return JumpFloorII(target-1)*2;
//    }

    /**
     * 方法一
     */
//    public int JumpFloorII(int target) {
//        if(target==0){
//            return 0;
//        }
//        return (int)Math.pow(2, target-1);
//    }
}
