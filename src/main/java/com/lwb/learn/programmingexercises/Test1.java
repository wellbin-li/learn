package com.lwb.learn.programmingexercises;
/**
 * 二维数组中的查找
 *
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Test1 {

    public static void main(String[] args) {
        int[][] a = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(find1(16, a));
        System.out.println(find2(16, a));
    }

    public static boolean find1(int target, int[][] array){
        int a = 0;
        int b = array[0].length-1;
        while(a<array.length&&b>=0){
            int temp = array[a][b];
            if(target==temp) return true;
            if(target<temp) b--;
            if(target>temp) a++;
        }
        return false;
    }

    public static boolean find2(int target, int[][] array){
        for(int i=0;i<array.length;i++){
            int low=0;
            int high = array[i].length-1;
            while(low<=high){
                int mid=(low+high)/2;
                if(target==array[i][mid]){
                    return true;
                }
                if(target>array[i][mid]){
                    low=mid+1;
                }
                if(target<array[i][mid]){
                    high=mid-1;
                }
            }
        }
        return false;
    }
}
