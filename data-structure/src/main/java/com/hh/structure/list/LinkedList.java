package com.hh.structure.list;

/**
 * @Description: 单向链表数据结构
 * @Author: hh
 * @date 2020/10/20
 */
public class LinkedList {

    public int val;
    public LinkedList next;

    public LinkedList(int val) {
        this.val = val;
    }

    public LinkedList(int val, LinkedList next) {
        this.val = val;
        this.next = next;
    }
}
