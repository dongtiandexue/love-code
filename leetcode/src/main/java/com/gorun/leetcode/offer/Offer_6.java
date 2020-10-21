//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 57 👎 0


package com.gorun.leetcode.offer;

import com.gorun.leetcode.pojo.ListNode;

import java.util.Stack;

/**
 * 单向链表：链表是一种动态数据结构，只需要给出链表头节点，就可以获得下一个节点
 */
public class Offer_6 {
    public static void main(String[] args) {
        Solution solution = new Offer_6().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {

        /**
         * 从头到尾遍历链表的每一个节点，将节点依次放入栈中
         * 遍历结束后，再从栈中依次弹出每一个节点并打印
         *
         * @param head
         * @return
         */
        public int[] reversePrintByStack(ListNode head) {
            Stack<Integer> stack = new Stack<Integer>();
            while (head != null) {
                stack.push(head.val);
                head = head.next;
            }

            int[] arr = new int[stack.size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = stack.pop();
            }
            return arr;
        }

        public int[] reversePrintByRec(ListNode head) {

            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}