//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
//请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
//。 
//
// 示例 1： 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36 
//
// 提示： 
//
// 
// 2 <= n <= 58 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划 
// 👍 107 👎 0


package com.gorun.leetcode.offer;

/**
 * 剪绳子问题有很多种解法
 * 1、数学公式推导：尽可能按大小为3的长度切割，最终得到的乘积最大
 * 2、贪心算法：
 * 3、动态规划
 * <p>
 * 动态规划是这几个算法中复杂度最高的，但是最近在学习动态规划，所以这里仅探讨如何使用动态规划解题
 */
public class Offer_14 {
    public static void main(String[] args) {
        Solution solution = new Offer_14().new Solution();
        System.out.println(solution.cuttingRope(2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int cuttingRope(int n) {
            if (n < 2) {
                return 0;
            }
            int[] dp = new int[n + 1];
            dp[2] = 1;

            for (int i = 3; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] = Math.max(dp[i], Math.max((i - j) * j, j * dp[i - j]));
                }
            }

            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}