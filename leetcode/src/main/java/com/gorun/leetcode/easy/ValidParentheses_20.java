//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1873 👎 0


package com.gorun.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ValidParentheses_20 {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses_20().new Solution();
        System.out.println(solution.isValid("{}{}[{()}]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isValid(String s) {

            HashMap<Character,Character> map = new HashMap<Character, Character>();
            map.put('}','{');
            map.put(']','[');
            map.put(')','(');

            Stack<Character> stack = new Stack<Character>();
            for (char c : s.toCharArray()) {
                if (map.containsKey(c)){
                    if (stack.isEmpty() || !stack.pop().equals(map.get(c))){
                        return false;
                    }
                }else {
                    stack.push(c);
                }
            }

            if (!stack.isEmpty()){
                return false;
            }

            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}