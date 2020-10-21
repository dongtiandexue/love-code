package com.hh.structure.tree;

/**
 * @Version: V1.0.0
 * @Description: 二叉树
 * @Author: gorun
 * @date 2020/8/29
 */
public class BinaryTreeNode {

    public int val;

    public BinaryTreeNode left;

    public BinaryTreeNode right;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(Integer value) {
        this.val = value;
    }

    public BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
