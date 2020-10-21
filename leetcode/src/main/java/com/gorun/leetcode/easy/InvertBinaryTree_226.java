//翻转一棵二叉树。
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 
// 👍 624 👎 0


package com.gorun.leetcode.easy;

import com.gorun.leetcode.pojo.TreeNode;

/**
 * 这道题翻转二叉树
 * 使用递归交换二叉树的左右子树
 */
public class InvertBinaryTree_226 {
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree_226().new Solution();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println("翻转前：" + root);
        System.out.println("翻转后：" + solution.invertTree(root));
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
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            if (root.left == null && root.right == null) {
                return root;
            }
            TreeNode temp = invertTree(root.left);
            root.left = invertTree(root.right);
            root.right = temp;
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}