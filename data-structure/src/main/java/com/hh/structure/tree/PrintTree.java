package com.hh.structure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 树的遍历
 * @Author: gorun
 * @date 2020/10/7
 */
public class PrintTree {

    public static void main(String[] args) {
        BinaryTreeNode<String> root = new BinaryTreeNode("A");
        root.left = new BinaryTreeNode("B");
        root.right = new BinaryTreeNode("C");
        root.left.left = new BinaryTreeNode("D");
        root.left.right = new BinaryTreeNode("E");
        root.right.left = new BinaryTreeNode("F");
        root.right.right = new BinaryTreeNode("G");

        PrintTree printTree = new PrintTree();

        printTree.preOrderTree(root);
        System.out.println("前序遍历");
        printTree.inOrderTree(root);
        System.out.println("中序遍历");
        printTree.postOrderTree(root);
        System.out.println("后序遍历");
        printTree.breadthOrderTree(root);
        System.out.println("广度优先遍历");
    }

    /**
     * 前序遍历：根 -> 左 -> 右
     *
     * @param root
     */
    public void preOrderTree(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderTree(root.left);
        preOrderTree(root.right);
    }

    /**
     * 中序遍历：左 -> 根 -> 右
     *
     * @param root
     */
    public void inOrderTree(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        preOrderTree(root.left);
        System.out.print(root.val + " ");
        preOrderTree(root.right);
    }

    /**
     * 后序遍历：左 -> 右 -> 根
     *
     * @param root
     */
    public void postOrderTree(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        preOrderTree(root.left);
        preOrderTree(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * 广度优先遍历
     * @param root
     */
    public void breadthOrderTree(BinaryTreeNode root){
        if (root == null){
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryTreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }

    }

    private static class BinaryTreeNode<T> {

        public T val;

        public BinaryTreeNode left;

        public BinaryTreeNode right;

        public BinaryTreeNode() {
        }

        public BinaryTreeNode(T value) {
            this.val = value;
        }

        public BinaryTreeNode(T val, BinaryTreeNode left, BinaryTreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
}
