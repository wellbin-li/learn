package com.lwb.learn.kzx;

import java.util.Scanner;

/**
 * 任务2：输入一行字符串，分别统计英文、空格、数字和其它字符个数
 *
 * @Author: liwenbin
 * @Date: 2019/05/08
 */
public class Assignment2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray(); //将输入的一行字符串转化为字符数组
        int englishCharCount = 0; //英文字符数量
        int blankCharCount = 0; //空格字符数量
        int numberCharCount = 0; //数字字符数量
        int otherCharCount = 0; //其它字符数量
        long start = System.currentTimeMillis();  //计时开始
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] >= 'A' && arr[i] <= 'Z') || (arr[i] >= 'a' && arr[i] <= 'z')) {  //英文字符
                englishCharCount++;
                continue;
            }
            if (arr[i] == ' ') { //空格字符
                blankCharCount++;
                continue;
            }
            if (arr[i] >= '0' && arr[i] <= '9') { //数字字符
                numberCharCount++;
                continue;
            }
            otherCharCount++;  //其它字符
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - start)); //统计过程耗时
        System.out.println("总字符数：" + arr.length);
        System.out.println("英文字符数：" + englishCharCount);
        System.out.println("空格字符数：" + blankCharCount);
        System.out.println("数字字符数：" + numberCharCount);
        System.out.println("其它字符数：" + otherCharCount);
    }
}
