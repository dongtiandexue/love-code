//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 499 👎 0


package com.hh.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 排序法解题法
         * @param strs
         * @return
         */
        public List<List<String>> groupAnagramsWithSort(String[] strs) {
            if (strs == null){
                return null;
            }
            HashMap<String, List<String>> map = new HashMap<String, List<String>>();
            for (String str : strs) {
                char[] chars = str.toCharArray();
                // 对字符串转换的字符数组排序
                Arrays.sort(chars);
                String key = new String(chars);
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<String>());
                }
                map.get(key).add(str);
            }

            return new ArrayList<List<String>>(map.values());
        }

        /**
         * 排序法解题法
         * @param strs
         * @return
         */
        public List<List<String>> groupAnagramsWithHash(String[] strs) {
            if (strs == null){
                return null;
            }
            HashMap<String, List<String>> map = new HashMap<String, List<String>>();
            for (String str : strs) {
                int[] arr = new int[26];
                for (char c : str.toCharArray()) {
                    arr[c - 'a']++;
                }

                StringBuilder sb = new StringBuilder();
                for (int i : arr) {
                    if (arr[i] != 0){
                        sb.append("#").append(i);
                    }
                }
                String key = sb.toString();
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<String>());
                }
                map.get(key).add(str);
            }

            return new ArrayList<List<String>>(map.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}