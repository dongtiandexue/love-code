//给定一个整数矩阵，找出最长递增路径的长度。
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。 
//
// 示例 1: 
//
// 输入: nums = 
//[
//  [9,9,4],
//  [6,6,8],
//  [2,1,1]
//] 
//输出: 4 
//解释: 最长递增路径为 [1, 2, 6, 9]。 
//
// 示例 2: 
//
// 输入: nums = 
//[
//  [3,4,5],
//  [3,2,6],
//  [2,2,1]
//] 
//输出: 4 
//解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
// 
// Related Topics 深度优先搜索 拓扑排序 记忆化 
// 👍 377 👎 0


/**
 * 最长递增路径长度
 * 深度优先遍历
 * 至少需要两层for循环即 m*n
 */
package com.hh.leetcode.hard;

public class LongestIncreasingPathInAMatrix_329 {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingPathInAMatrix_329().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[][] memo;
        private int rows;
        private int cols;

        public int longestIncreasingPath(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }
            rows = matrix.length;
            cols = matrix[0].length;
            int result = Integer.MIN_VALUE;
            memo = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result = Math.max(result, dfs(matrix, i, j, Integer.MIN_VALUE));
                }
            }
            return result;
        }

        private int dfs(int[][] matrix, int i, int j, int value) {
            // 递归结束条件
            if (i >= rows || i < 0 || j >= cols || j < 0) {
                return 0;
            }
            if (matrix[i][j] <= value) {
                return 0;
            }
            if (memo[i][j] != 0) {
                return memo[i][j];
            }

            // 遍历节点的上下左右节点，取出最大可能，并加1
            int up = dfs(matrix, i - 1, j, matrix[i][j]);
            int down = dfs(matrix, i + 1, j, matrix[i][j]);
            int left = dfs(matrix, i, j - 1, matrix[i][j]);
            int right = dfs(matrix, i, j + 1, matrix[i][j]);
            memo[i][j] = Math.max(up, Math.max(down, Math.max(left, right))) + 1;
            return memo[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}