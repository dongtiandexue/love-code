package com.gorun.offer.topic18_1;

import com.gorun.offer.pojo.ListNode;

/**
 * @Version: V1.0.0
 * @Description: 在O(1)时间内删除链表的节点
 * @Author: gorun
 * @date 2020/8/16
 */
public class Solution {

    public ListNode deleteNode(ListNode head, ListNode deleteNode) {
        if(head == null || deleteNode == null){
            return head;
        }
        if(head == deleteNode){
            // 如果首节点就是要删除的节点,直接返回 head.next
            return head.next;
        }
        if(deleteNode.next == null){
            // 如果要删除的节点是尾部节点，只能遍历链表找到首节点的上一个节点
            ListNode node = head;
            while(node.next != null){
                if(node.next == deleteNode){
                    break;
                }
                node = node.next;
            }

        }else {
            ListNode nodeNext = deleteNode.next;
//            deleteNode.next(nodeNext.next);
//            deleteNode.next(nodeNext.next);
        }
        return head;
    }
}
