//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须原地修改，只允许使用额外常数空间。 
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 
//1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics 数组 
// 👍 822 👎 0


package com.hh.leetcode.middle;

public class NextPermutation_31 {
    public static void main(String[] args) {
        Solution solution = new NextPermutation_31().new Solution();
        int[] nums = new int[]{1,5,4,3,2};
        solution.nextPermutation(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {

            //1、特殊数据处理
            if (nums == null || nums.length <= 1) {
                return;
            }

            int start = 0;
            int end = nums.length - 1;

            //2、遍历数组，判断该数组状态
            out:for (int i = nums.length - 1; i > 0; i--) {

                //2.1 如果存在 nums[i] > nums[i-1] 则表明该数组中，存在下一个更大排列
                if (nums[i] > nums[i - 1]) {
                    start = i;
                    //2.2 遍历数组 [i,~] 范围，找出最接近且大于 nums[i-1] 的元素, 假设下标为k
                    // 交换 nums[k] 与 nums[i-1] 元素
                    for (int j = nums.length - 1; j >= i; j--) {
                        if (nums[j] > nums[i - 1]) {
                            swap(i - 1, j, nums);
                            break out;
                        }
                    }
                }
            }

            reverse(start, end, nums);
        }

        private void reverse(int start, int end, int[] nums) {
            while (start < end) {
                swap(start++, end--, nums);
            }
        }

        private void swap(int first, int second, int[] nums) {
            int temp = nums[first];
            nums[first] = nums[second];
            nums[second] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}