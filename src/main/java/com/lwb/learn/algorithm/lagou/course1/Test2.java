package com.lwb.learn.algorithm.lagou.course1;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出数组中出现次数最多的数及其个数
 * 方法1 时间复杂度为O(n^2)
 * 方法2 时间复杂度为O(n)
 * 方法： 利用数据结构牺牲空间换取时间
 */
public class Test2 {

    /**
     * 方法1 时间复杂度O(n^2)
     */
    public static void s2_1(){
        int a[] = { 1, 2, 3, 4, 5, 5, 6 };
        int tmp;
        int max=-1;
        int max_value=-1;
        for (int i=0;i<a.length;i++){
            tmp = 0;
            for (int j=0;j<a.length;j++){
                if(a[i]==a[j]){
                    tmp++;
                }
            }
            if(tmp>max_value){
                max_value=tmp;
                max = a[i];
            }
        }
        System.out.println(max);
        System.out.println(max_value);
    }

    /**
     * 方法2 时间复杂度O(n)
     */
    public static void s2_2(){
        Map<Integer,Integer> map1 = new HashMap<Integer,Integer>();
        int a[] = { 1, 2, 3, 4, 5, 5, 6 };
        int max = -1;
        int max_value = -1;
        for (int i = 0; i < a.length; i++) {
            if(map1.containsKey(a[i])){
                map1.put(a[i],map1.get(a[i])+1);
            }else{
                map1.put(a[i],1);
            }
        }
        for(Integer i : map1.keySet()){
            if(map1.get(i)>max_value) {
                max_value=map1.get(i);
                max = i;
            }
        }
        System.out.println(max);
        System.out.println(max_value);
    }

    public static void main(String[] args) {
        s2_1();
        s2_2();
    }
}
