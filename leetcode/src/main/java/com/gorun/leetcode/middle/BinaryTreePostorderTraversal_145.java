//给定一个二叉树，返回它的 后序 遍历。
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 453 👎 0


package com.gorun.leetcode.middle;

import com.gorun.leetcode.pojo.TreeNode;

import java.util.*;

public class BinaryTreePostorderTraversal_145 {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal_145().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode prev = null;
            while(root != null || !stack.isEmpty()){
                while (root != null){
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.right == null || root.right == prev){
                    res.add(root.val);
                    prev = root;
                    root = null;
                }else {
                    stack.push(root);
                    root = root.right;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}