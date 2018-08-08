package com.lwb.learn.programmingexercises;

/**
 * 矩形覆盖
 *
 * 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Test10 {

    /**
     * 方法二
     */
    public int RectCover(int target) {
        if(target<=2)
            return target;
        int a=1;
        int b=2;
        int res=-1;
        for(int i=3;i<=target;i++){
            res=a+b;
            a=b;
            b=res;
        }
        return res;
    }

    /**
     * 方法一
     */
//    public int RectCover(int target) {
//        if(target<3){
//            return target;
//        }
//        return RectCover(target-1)+RectCover(target-2);
//    }
}
