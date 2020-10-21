package com.gorun.offer.topic32_1;

import com.gorun.offer.pojo.BinaryTreeNode;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Version: V1.0.0
 * @Description: TODO
 * @Author: gorun
 * @date 2020/8/31
 */
public class PrintBinaryTreeNode {

    public int[] printTree(BinaryTreeNode root){
        if(root == null){
            return new int[0];
        }
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>(){{ add(root); }};
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (queue.isEmpty()){
            BinaryTreeNode node = queue.poll();
            list.add(node.value);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }

        // 将 ArrayList 转为 int数组并返回
        int[] res = new int[list.size()];
        for (int i=0; i<res.length; i++) {
            res[i] = list.get(i);
        }
        return res;

    }
}
