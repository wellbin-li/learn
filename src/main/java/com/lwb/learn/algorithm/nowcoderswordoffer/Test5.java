package com.lwb.learn.algorithm.nowcoderswordoffer;

import java.util.Stack;

/**
 * 题目5：用两个栈实现队列
 * <p>
 * 题目描述：
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Test5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 思路一：保证所有元素存储在stack1，只需要取的时候放到中stack2取，取完之后放回stack1
     */
    public void push1(int node) {
        stack1.push(node);
    }

    public int pop1() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int vaule = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return vaule;
    }


    /**
     * 思路二：存之前保证所有元素在stack1，取之前保证所有元素在stack2
     */
    public void push2(int node) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop2() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
