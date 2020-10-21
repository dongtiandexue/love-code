package com.gorun.leetcode.pojo;

/**
 * @Version: V1.0.0
 * @Description: TODO
 * @Author: gorun
 * @date 2020/8/12
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
