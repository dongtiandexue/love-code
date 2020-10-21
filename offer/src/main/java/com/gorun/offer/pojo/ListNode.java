package com.gorun.offer.pojo;

/**
 * @Version: V1.0.0
 * @Description: 定义链表数据结构
 * @Author: gorun
 * @date 2020/8/16
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
