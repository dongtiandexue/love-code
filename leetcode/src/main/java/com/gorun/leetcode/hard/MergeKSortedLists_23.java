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
// 👍 942 👎 0


package com.gorun.leetcode.hard;

import com.gorun.leetcode.pojo.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists_23 {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists_23().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)


    /**
     * 给你一个链表数组，要求按照升序对链表中的每个节点排序
     * 这里用到了JDK中的PriorityQueue优先队列，可以对队列中的元素排序，并且按照先进先出顺序读取元素
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {

            //1、校验数组是否为空
            if (lists == null || lists.length == 0) {
                return null;
            }

            //2、使用优先队列对ListNode排序
            PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparing(node -> node.val));
            for (ListNode node : lists) {
                if (node != null) {
                    queue.add(node);
                }
            }

            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            while (!queue.isEmpty()) {
                tail.next = queue.poll();
                tail = tail.next;
                if (tail.next != null) {
                    queue.add(tail.next);
                }
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}