package com.gorun.offer.pojo;

/**
 * @Version: V1.0.0
 * @Description: 二叉树
 * @Author: gorun
 * @date 2020/8/29
 */
public class BinaryTreeNode {

    public int value;

    public BinaryTreeNode left;

    public BinaryTreeNode right;

    public BinaryTreeNode(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
