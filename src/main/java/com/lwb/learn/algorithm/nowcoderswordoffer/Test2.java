package com.lwb.learn.algorithm.nowcoderswordoffer;

/**
 * 题目2：替换空格
 * <p>
 * 题目描述：
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Test2 {
    /**
     * 思路一：直接使用String的replace方法进行替换
     */
    public String replaceSpace1(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }

    /**
     * 思路二：构造一个新的StringBuilder，遍历StringBuffer中的每个字符，若遇到空格则append("%20"),否则append这个字符，
     * 最后返回StringBuilder
     */
    public String replaceSpace2(StringBuffer str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
