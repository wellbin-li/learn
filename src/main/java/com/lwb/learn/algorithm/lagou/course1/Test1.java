package com.lwb.learn.algorithm.lagou.course1;

import java.util.HashSet;

/**
 * 找出10000中能同时被7,3,2整除的数的个数
 * 个数为1191903
 * 方法1 时间复杂度为O(n^3)，花费时间43834ms
 * 方法2 时间复杂度为O(n^2)，花费时间956ms
 */
public class Test1 {
    static int num = 10000;
    static HashSet<String> hashSet1 = new HashSet<String>();
    static HashSet<String> hashSet2 = new HashSet<String>();

    /**
     * 方法1 时间复杂度O(n^3)
     */
    public static void s2_1(){
        int count = 0;
        long begin = System.currentTimeMillis();
        for (int i=0;i<(num/7);i++){
            for (int j=0;j<(num/3);j++){
                for (int k=0;k<(num/2);k++){
                    if((i*7+j*3+k*2)==num){
                        count++;
                        hashSet1.add(i+"," +j+ ","+k);
                    }
                }
            }
        }
        System.out.println(count);
        System.out.println(System.currentTimeMillis()-begin);
    }

    /**
     * 方法2 时间复杂度O(n^2)
     */
    public static void s2_2(){
        int count = 0;
        long begin = System.currentTimeMillis();
        for (int i=0;i<(num/7);i++){
            for (int j=0;j<(num/3);j++){
                if((num-i*7-j*3)%2==0&&(num-i*7-j*3)/2>=0&&(num-i*7-j*3)<num){
                    count++;
                    hashSet2.add(i+"," +j+ ","+(num-i*7-j*3)/2);
                }
            }
        }
        System.out.println(count);
        System.out.println(System.currentTimeMillis()-begin);
    }

    public static void main(String[] args) {
        s2_1();
        s2_2();
        for(String str:hashSet1){
            if(!hashSet2.contains(str)){
                System.out.println(str);
            }
        }
        for(String str:hashSet2){
            if(!hashSet1.contains(str)){
                System.out.println(str);
            }
        }
    }
}
