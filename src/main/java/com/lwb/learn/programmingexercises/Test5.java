package com.lwb.learn.programmingexercises;

import java.util.Stack;

/**
 * 用两个栈实现一个队列
 *
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Test5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 方法二
     */
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /**
     * 方法一
     */
//    public void push(int node) {
//        while(!stack2.empty()){
//            stack1.push(stack2.pop());
//        }
//        stack1.push(node);
//    }
//
//    public int pop() {
//        while (!stack1.empty()){
//            stack2.push(stack1.pop());
//        }
//        return stack2.pop();
//    }
}
