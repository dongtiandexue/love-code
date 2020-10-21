//package com.gorun.offer.topic23;
//
//import com.gorun.offer.pojo.ListNode;
//
//import java.util.List;
//
///**
// * @Version: V1.0.0
// * @Description: TODO
// * @Author: gorun
// * @date 2020/8/23
// */
//public class Solution {
//
//
//
//    public ListNode entryNodeOfLoop(ListNode head) {
//        // 判断链表中是否有环
//        ListNode meetingNode = meetingNode(head);
//        if (meetingNode == null) {
//            return null;
//        }
//        // 得到环中节点的个数
//        int size = 1;
//        while (meetingNode.() == meetingNode) {
//            meetingNode = meetingNode.getNext();
//            size++;
//        }
//
//        // 得到环的入口
//        ListNode node1 = head;
//        for (int i = 0; i < size; i++) {
//            node1 = node1.getNext();
//        }
//
//        ListNode node2 = head;
//        while (node1 != node2) {
//            node1 = node1.getNext();
//            node2 = node2.getNext();
//        }
//        return node1;
//    }
//
//    public ListNode meetingNode(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        // 慢指针一次走一步
//        ListNode slow = head.getNext();
//        if (slow == null) {
//            return null;
//        }
//        // 快指针一次走两步
//        ListNode fast = slow.getNext();
//        while (slow != null && fast != null) {
//            if (slow == fast) {
//                return fast;
//            }
//            slow = slow.getNext();
//            fast = fast.getNext();
//            if (fast != null) {
//                fast = fast.getNext();
//            }
//
//        }
//        return null;
//    }
//}
