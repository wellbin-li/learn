package com.lwb.learn.programmingexercises;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头打印链表
 *
 * 题目描述
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class Test3 {

    public static void main(String[] args) {
        ListNode lNode1 = new ListNode(1);
        ListNode lNode2 = new ListNode(2);
        ListNode lNode3 = new ListNode(3);
        lNode1.next=lNode2;
        lNode2.next=lNode3;
        System.out.println(printListFromTailToHead1(lNode1));
        System.out.println(printListFromTailToHead2(lNode1));
    }

    /**
     * 方法一：递归
     */
    static ArrayList<Integer> list = new ArrayList<>();
    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        if (listNode!=null){
            printListFromTailToHead1(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }

    /**
     * 方法二：栈
     */
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<Integer>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while(!stack.isEmpty()){
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
