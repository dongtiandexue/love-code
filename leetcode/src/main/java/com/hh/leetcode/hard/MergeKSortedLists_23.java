//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 堆 链表 分治算法 
// 👍 971 👎 0


package com.hh.leetcode.hard;

import com.hh.leetcode.pojo.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists_23 {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists_23().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {

        /**
         * 方法1：采用优先队列，遍历链表中的每一个元素
         * @param lists
         * @return
         */
        public ListNode mergeKListsWithQueue(ListNode[] lists) {
            ListNode dummy = new ListNode(0);
            ListNode head = dummy;
            if (lists == null || lists.length == 0) {
                return dummy.next;
            }

            //1、创建优先队列
            PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

            //2、遍历数组，将链表头节点放入队列中
            for (ListNode node : lists) {
                if (node != null) queue.add(node);
            }

            //3、循环取出队列中的最小元素，直到队列为空
            while (!queue.isEmpty()){
                ListNode node = queue.poll();
                head.next = node;
                head = head.next;
                if (node.next != null){
                    queue.add(node.next);
                }
            }

            return dummy.next;

        }


        /**
         * 方法2：采用分而治之的思想，将多个队列的合并变成两两链表的合并
         * @param lists
         * @return
         */
        public ListNode mergeKListsWithSub(ListNode[] lists) {
            ListNode dummy = new ListNode(0);
            ListNode head = dummy;
            if (lists == null || lists.length == 0) {
                return dummy.next;
            }

            //1、创建优先队列
            PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

            //2、遍历数组，将链表头节点放入队列中
            for (ListNode node : lists) {
                if (node != null) queue.add(node);
            }

            //3、循环取出队列中的最小元素，直到队列为空
            while (!queue.isEmpty()){
                ListNode node = queue.poll();
                head.next = node;
                head = head.next;
                if (node.next != null){
                    queue.add(node.next);
                }
            }

            return dummy.next;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}