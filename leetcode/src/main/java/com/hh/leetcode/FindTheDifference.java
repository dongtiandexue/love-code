//给定两个字符串 s 和 t，它们只包含小写字母。
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。 
//
// 请找出在 t 中被添加的字母。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abcd", t = "abcde"
//输出："e"
//解释：'e' 是那个被添加的字母。
// 
//
// 示例 2： 
//
// 输入：s = "", t = "y"
//输出："y"
// 
//
// 示例 3： 
//
// 输入：s = "a", t = "aa"
//输出："a"
// 
//
// 示例 4： 
//
// 输入：s = "ae", t = "aea"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 1000 
// t.length == s.length + 1 
// s 和 t 只包含小写字母 
// 
// Related Topics 位运算 哈希表 
// 👍 159 👎 0


package com.hh.leetcode;

/**
 * 找不同：
 * 理解题意：
 * 给定两个字符串s和t，其中t实在s的基础上再加一个字符，现在要找出这个字符。
 * 根据题目意思，有两种解题方法：
 * 方法1：哈希表法，我们都知道字母可以转换为ASCII码，其中 a 的 ASCII为97，b的ASCII为98
 * 创建一个大小为26的数组对应存放26个小写字母，其中 a - a = 97 - 97 = 0,b - a = 98 - 97 = 1 可以存放在下标为1的位置
 * 将字符串s的每个字符存放到数组中，对应位置数量 加1
 * 再遍历字符串t的每个字符，将对应数组中的位置 减1，最终遍历数组，值不为0的位置即为不相同的字符
 * 方法2：加法
 * 将字符串s的每个字符ASCII码加起来，将字符串t的每个字符ASCII码加起来，字符串s和t的ASCII码总和差值即为多出来的字符ASCII码，最终转换为字符
 */
public class FindTheDifference {
    public static void main(String[] args) {
        Solution solution = new FindTheDifference().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char findTheDifference(String s, String t) {
            if (s == null) {
                return t.charAt(0);
            }
            int[] arr = new int[26];

            // 遍历字符串s和t,将字母转换为数组对应位置索引
            for (int i = 0; i < t.length(); i++) {
                if (i < s.length()) {
                    // 字符串s中的字母对应数组中的位置+1
                    arr[s.charAt(i) - 'a']++;
                }
                // 字符串t中的字母对应数组中的位置-1
                arr[t.charAt(i) - 'a']--;
            }

            // 遍历数组，找出值不为0的那个位置，即为不同的字符
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    return (char) ('a' + i);
                }
            }
            return 'a';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}