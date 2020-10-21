package com.gorun.offer.topic22;

import com.gorun.offer.pojo.ListNode;

import java.util.List;

/**
 * @Version: V1.0.0
 * @Description: TODO
 * @Author: gorun
 * @date 2020/8/23
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next =  new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        Solution solution = new Solution();
        System.out.println(solution.getKthFromEnd(head, 3).val);
    }

    private ListNode getKthFromEnd(ListNode head, int k) {
        // 保证代码健壮性
        if (head == null || k <= 0) {
            return null;
        }
        // 初始时 fast 和 slow 都指向头节点
        ListNode fast = head;
        ListNode slow = head;

        // 遍历链表，让 fast 节点先走 k 个节点
        for (int i = 1; i < k; i++) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }

        // fast 和 slow 保持 k 个节点的距离，当 fast 指向的节点为null时，
        // slow 位置就是倒数第k个元素
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
