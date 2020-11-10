//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/ 
// Related Topics 树 广度优先搜索 
// 👍 60 👎 0


package com.hh.leetcode;

import com.hh.leetcode.pojo.TreeNode;

import java.util.*;

public class CongShangDaoXiaDaYinErChaShuIiLcof {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            // 1、定义result集合作为返回值
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            // 2、bfs遍历需要借助queue辅助空间
            Queue<TreeNode> queue = new ArrayDeque<>();
            // 定义遍历left表示默认从左开始遍历
            boolean left = true;
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                LinkedList<Integer> temp = new LinkedList<>();
                while (size-- > 0) {
                    TreeNode node = queue.poll();
                    if (left) {
                        // 从左到右-依次加入到队列尾部
                        temp.addLast(node.val);
                    } else {
                        // 从右到左-依次加入到队列头部
                        temp.addFirst(node.val);
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                left = !left;
                result.add(temp);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}