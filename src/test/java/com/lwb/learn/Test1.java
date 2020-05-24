package com.lwb.learn;

import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.nextLine();
        String word2 = sc.nextLine();
        System.out.println(minDistance(word1, word2));
    }

    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int dp[][] = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++)//word1删除元素
        {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++)//word1插入元素
        {
            dp[0][j] = j;
        }

        for (int i = 0; i < len1; i++) {
            char c1 = word1.charAt(i);
            for (int j = 0; j < len2; j++) {
                char c2 = word2.charAt(j);
                if (c1 == c2) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int insert = dp[i + 1][j] + 1;
                    int delete = dp[i][j + 1] + 1;
                    int replace = dp[i][j] + 1;
                    int min = insert > delete ? delete : insert;
                    min = min > replace ? replace : min;
                    dp[i + 1][j + 1] = min;
                }
            }
        }
        return dp[len1][len2];
    }
}
