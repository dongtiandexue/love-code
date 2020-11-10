package com.hh.algorithm.bfs;

import com.hh.algorithm.pojo.TreeNode;

import java.util.ArrayDeque;

/**
 * @Description: TODO
 * @Author: hh
 * @date 2020/11/1
 */
public class BFSSearchTest {

    /**
     * 广度优先遍历
     * 采用非递归实现
     * 需要辅助数据结构：队列
     */
    public void bfs(TreeNode root) {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.print("\n");
    }
}
