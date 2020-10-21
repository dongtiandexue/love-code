package com.gorun.offer.topic28;

import com.gorun.offer.pojo.BinaryTreeNode;

/**
 * @Version: V1.0.0
 * @Description: 判断二叉树是否对称
 * @Author: gorun
 * @date 2020/8/29
 */
public class BinaryTreeSymmetry {

    public static void main(String[] args) {
        BinaryTreeNode head = new BinaryTreeNode(8);
        head.left = new BinaryTreeNode(6);
        head.right = new BinaryTreeNode(6);
        head.left.left = new BinaryTreeNode(5);
        head.left.right = new BinaryTreeNode(7);
        head.right.left = new BinaryTreeNode(7);
        head.right.right = new BinaryTreeNode(5);

        BinaryTreeSymmetry binaryTreeMirror = new BinaryTreeSymmetry();
        System.out.println(binaryTreeMirror.isSymmertical(head));
    }

    public boolean isSymmertical(BinaryTreeNode p){
        return isSymmertical(p,p);
    }

    public boolean isSymmertical(BinaryTreeNode p1, BinaryTreeNode p2){
        if(p1 == null && p2 == null){
            return true;
        }
        if(p1 == null || p2 == null){
            return false;
        }
        if(p1.value != p2.value){
            return false;
        }

        return isSymmertical(p1.left,p2.right) && isSymmertical(p1.right,p2.left);


    }
}
