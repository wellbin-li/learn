package com.lwb.learn.algorithm.nowcoderswordoffer;

import java.util.Arrays;

/**
 * 题目4：重建二叉树
 * <p>
 * 题目描述：
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Test4 {

    /**
     * 思路一：用Arrays.copyOfRange工具控制边界
     */
    public static TreeNode reConstructBinaryTree1(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                treeNode.left = reConstructBinaryTree1(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                treeNode.right = reConstructBinaryTree1(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return treeNode;
    }

    /**
     * 思路二：手动控制边界
     */
    public static TreeNode reConstructBinaryTree2(int[] pre, int[] in) {
        TreeNode treeNode = reConstructBinaryTreeByBorder(pre, 0, pre.length, in, 0, in.length);
        return treeNode;
    }

    public static TreeNode reConstructBinaryTreeByBorder(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (endPre <= startPre || endIn <= startIn) {
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[startPre]);
        for (int i = startIn; i < endIn; i++) {
            if (in[i] == pre[startPre]) {
                treeNode.left = reConstructBinaryTreeByBorder(pre, startPre + 1, startPre + i - startIn + 1, in, startIn, i);
                treeNode.right = reConstructBinaryTreeByBorder(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
            }

        }
        return treeNode;
    }

    public static void printArray(int[] a, int start, int end) {
        for (int i = start; i < end; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    /**
     * 前序遍历二叉树
     */
    public static void printTreeNodeByPre(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.print(treeNode.val + " ");
            printTreeNodeByPre(treeNode.left);
            printTreeNodeByPre(treeNode.right);
        }
    }

    /**
     * 中序遍历二叉树
     */
    public static void printTreeNodeByIn(TreeNode treeNode) {
        if (treeNode != null) {
            printTreeNodeByIn(treeNode.left);
            System.out.print(treeNode.val + " ");
            printTreeNodeByIn(treeNode.right);
        }
    }

    /**
     * 后序遍历二叉树
     */
    public static void printTreeNodeByAft(TreeNode treeNode) {
        if (treeNode != null) {
            printTreeNodeByAft(treeNode.left);
            printTreeNodeByAft(treeNode.right);
            System.out.print(treeNode.val + " ");
        }
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8}; //前序
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6}; //中序
        TreeNode treeNode = reConstructBinaryTree2(pre, in); //重建二叉树
        printTreeNodeByPre(treeNode); //前序遍历
        System.out.println(" ");
        printTreeNodeByIn(treeNode);  //中序遍历
        System.out.println(" ");
        printTreeNodeByAft(treeNode); //后序遍历

    }

}

/**
 * 树节点
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
