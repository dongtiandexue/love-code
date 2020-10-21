//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 分治算法 动态规划 
// 👍 124 👎 0


package com.gorun.leetcode.offer;

/**
 * 这道理我想了一段时间还是有点迷糊它的解题思路
 * 需要时刻保留到nums[i]为止的连续子数组的最大值，必须要包含nums[i]，不然求nums[i+1]是无法保证子数组连续
 * 则有，如果nums[i-1] <= 0,则nums[i-1] 对 nums[i] 一点用都没有，还不如 nums[i] 本身
 *
 * 这道题的理论如果看不明白，需要画图来解释
 * 如果理解了出题者的意图，那么这道题不难
 *
 */
public class Offer_42 {
    public static void main(String[] args) {
        Solution solution = new Offer_42().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                nums[i] += Math.max(nums[i - 1], 0);
                max = Math.max(max, nums[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}