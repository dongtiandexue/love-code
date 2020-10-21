package com.gorun.offer.topic32_2;

import com.gorun.offer.pojo.BinaryTreeNode;
import com.gorun.offer.topic28.BinaryTreeSymmetry;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

    public void printTree(BinaryTreeNode root){
        if(root == null){
            return ;
        }
        int nextLevel = 0;
        // 初始化未打印节点数量
        int toBePrinted = 1;
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>(){{ add(root); }};
        while (!queue.isEmpty()){
            BinaryTreeNode node = queue.poll();
            System.out.print(node.value);
            if(node.left != null){
                queue.add(node.left);
                nextLevel++;
            }
            if(node.right != null){
                queue.add(node.right);
                nextLevel ++;
            }
            if (--toBePrinted == 0){
                System.out.println();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
    }
}
