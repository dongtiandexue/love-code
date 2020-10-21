package com.gorun.leetcode.pojo;

/**
 * @Description: 采用链表实现的链式栈
 * @Author: gorun
 * @date 2020/10/6
 */
public class LinkStack {

    /**
     * 定义链栈的结点
     * Object类型的数据域
     * Node类型的指针域
     *
     * @author MWL
     */
    private class Node {
        Object data;
        Node next;

        public Node() {
        }

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node top;   //栈顶元素
    private int size;   //当前栈的大小

    /**
     * 创建空链栈
     */
    public LinkStack() {
        top = null;
    }

    /**
     * 以data数据元素创建链式栈
     *
     * @param data
     */
    public LinkStack(Object data) {
        top = new Node(data, null);
        size++;
    }

    /**
     * 判断链栈是否为空栈
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    /**
     * 返回链栈的长度
     *
     * @return
     */
    public int length() {
        return size;
    }

    /**
     * 压栈(入栈)
     *
     * @param data
     */
    public void push(Object data) {
        // 让top指向新创建的元素，新元素的next引用指向原来的栈顶元素
        top = new Node(data, top);
        size++;
    }

    /**
     * 出栈
     *
     * @return
     */
    public Object pop() {

        if (isEmpty()) {
            System.out.println("目前是空栈，无法进行出栈!");
            return "error!";
        }
        Node temp = top;
        // 更新头结点
        top = top.next;
        // 释放原栈顶元素的next引用，删除指针指向
        temp.next = null;
        size--;
        return temp.data;
    }

    /**
     * 访问栈顶元素
     *
     * @return
     */
    public Object peek() {
        if (top != null) {
            return top.data;
        }
        return "空栈，无栈顶元素!";
    }

    /**
     * 遍历栈并打印栈内元素
     */
    public void displayStack() {
        while (top != null) {
            System.out.println(top.data + "\t");
            top = top.next;
        }
    }

    /**
     * 清空栈
     */
    public void clear() {
        top = null;
        size = 0;
    }
}

