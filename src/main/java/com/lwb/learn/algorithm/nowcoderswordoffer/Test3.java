package com.lwb.learn.algorithm.nowcoderswordoffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目3：从尾到头打印链表
 * <p>
 * 题目描述：
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class Test3 {
    /**
     * 思路一：递归
     */
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead1(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }

    /**
     * 思路二：栈
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

