package com.gorun.offer.topic32_3;

import com.gorun.offer.pojo.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Version: V1.0.0
 * @Description: TODO
 * @Author: gorun
 * @date 2020/8/31
 */
public class PrintBinaryTreeNode {

    public static void main(String[] args) {
        BinaryTreeNode head = new BinaryTreeNode(8);
        head.left = new BinaryTreeNode(6);
        head.right = new BinaryTreeNode(10);
        head.left.left = new BinaryTreeNode(5);
        head.left.right = new BinaryTreeNode(7);
        head.right.left = new BinaryTreeNode(9);
        head.right.right = new BinaryTreeNode(11);

        PrintBinaryTreeNode printBinaryTreeNode = new PrintBinaryTreeNode();
        printBinaryTreeNode.printTree(head);
    }

    public void printTree(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        int current = 0;
        // 初始化未打印节点数量
        int next = 1;
        Stack<BinaryTreeNode>[] stacks = new Stack[]{
                new Stack<BinaryTreeNode>(),new Stack<BinaryTreeNode>()
        };
        stacks[current].push(root);

        while (!stacks[0].isEmpty()|| !stacks[1].isEmpty()) {
            Stack<BinaryTreeNode> stack = stacks[current];
            BinaryTreeNode treeNode = stack.pop();
            System.out.print(treeNode.value);
            if (current == 1) {
                if (treeNode.right != null) {
                    stacks[next].push(treeNode.right);
                }
                if (treeNode.left != null) {
                    stacks[next].push(treeNode.left);
                }

            } else {

                if (treeNode.left != null) {
                    stacks[next].push(treeNode.left);
                }
                if (treeNode.right != null) {
                    stacks[next].push(treeNode.right);
                }
            }

            // stack 为空，某一层已经打印完毕，切换为下一层
            // 切换打印方向
            if (stack.isEmpty()) {
                System.out.println();
                current = 1 - current;
                next = 1 - next;
            }

        }
    }
}
