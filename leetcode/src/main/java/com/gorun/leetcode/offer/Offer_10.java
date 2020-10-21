//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
//
// F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2
//输出：1
// 
//
// 示例 2： 
//
// 输入：n = 5
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 509 题相同：https://leetcode-cn.com/problems/fibonacci-number/ 
// Related Topics 递归 
// 👍 60 👎 0


package com.gorun.leetcode.offer;

/**
 * 使用动态规划解决斐波那契数列问题
 * 状态定义：设dp为一维数组，其中dp[n]代表斐波那契数列第n个数字
 * 初始状态：F(0) = 0, F(1) = 1
 * 状态转移方程：dp[n] = dp[n-1] + dp[n-2] 即 F(N) = F(N - 1) + F(N - 2), 其中 N > 1
 * 返回值：dp[n],即斐波那契数列第n个数字
 * <p>
 * 动态规划空间复杂度优化：
 * dp算法适合解决两类问题：存在重叠子问题，最优子结构
 * 由于dp[n] 之和 dp[n-1] 和 dp[n-2] 有关，定义 a = dp[n-2], b = dp[n-1], sum = a + b = dp[n-1] + dp[n-2]
 * 利用辅助变量 sum 使 a, b两数字交替前进即可 (具体详见代码)
 */
public class Offer_10 {

    public static void main(String[] args) {
        Solution solution = new Offer_10().new Solution();
        System.out.println(solution.fib(10));
    }

    class Solution {
        public int fib(int n) {
            int a = 0, b = 1, sum;
            for (int i = 0; i < n; i++) {
                sum = a + b;
                a = b;
                b = sum;
            }
            return a;
        }
    }

}