package com.gorun.offer.topic27;

import com.gorun.offer.pojo.BinaryTreeNode;
import com.gorun.offer.pojo.TreeNode;

/**
 * @Version: V1.0.0
 * @Description: 二叉树的镜像
 * @Author: gorun
 * @date 2020/8/29
 */
public class BinaryTreeMirror {

    public static void main(String[] args) {
        BinaryTreeNode head = new BinaryTreeNode(8);
        head.left = new BinaryTreeNode(6);
        head.right = new BinaryTreeNode(10);
        head.left.left = new BinaryTreeNode(5);
        head.left.right = new BinaryTreeNode(7);
        head.right.left = new BinaryTreeNode(9);
        head.right.right = new BinaryTreeNode(11);

        BinaryTreeMirror mirror = new BinaryTreeMirror();
        System.out.println(mirror.mirror(head));

    }

    public BinaryTreeNode mirror(BinaryTreeNode head) {
        if(head == null || (head.left == null && head.right == null)){
            return null;
        }
        BinaryTreeNode left = mirror(head.left);
        BinaryTreeNode right = mirror(head.right);
        head.right = left;
        head.left = right;
        return head;


    }
}
