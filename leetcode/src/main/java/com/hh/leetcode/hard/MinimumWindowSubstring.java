//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 845 👎 0


package com.hh.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖字串
 * 滑动窗口问题
 * 使用left，right 双指针构成滑动窗口
 * 首先：left = right = 0
 * 然后：right++,增大滑动窗口并统计滑动窗口中是否包含目标子串
 * 然后：left--,减小滑动窗口统计满足条件下的最优解，直到滑动窗口不包含目标字串
 * 最后：继续增大 right，重复步骤2和3，直到right到达s字符串末尾
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(solution.minWindow(s, t));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            //1、将目标字符串封装为字符数组，并统计每个字符个数
            Map<Character, Integer> targetMap = new HashMap<>();
            Map<Character, Integer> windowMap = new HashMap<>();
            for (char c : t.toCharArray()) {
                targetMap.put(c, targetMap.get(c) == null ? 1 : targetMap.get(c) + 1);
            }
            //2、定义双指针
            int left = 0;
            int right = 0;

            //3、valid判断滑动窗口是否满足目标字符串
            int valid = 0;

            //4、定义其实索引与最优结果
            int start = 0;
            int len = Integer.MAX_VALUE;
            char[] sourceArr = s.toCharArray();
            while (right < sourceArr.length) {
                char c = sourceArr[right];
                right++;
                if (targetMap.containsKey(c)) {
                    windowMap.put(c, windowMap.get(c) == null ? 1 : windowMap.get(c) + 1);
                    if (windowMap.get(c).equals(targetMap.get(c))) {
                        valid++;
                    }
                }

                while (valid == targetMap.size()) {
                    if (len > right - left) {
                        // 保存最优解滑动窗口大小
                        start = left;
                        len = right - left;
                    }
                    char d = sourceArr[left];
                    left++;
                    if (targetMap.containsKey(d)) {
                        if (windowMap.get(d).equals(targetMap.get(d))) {
                            valid--;
                        }
                        windowMap.put(d, windowMap.get(d) - 1);
                    }

                }
            }
            return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}