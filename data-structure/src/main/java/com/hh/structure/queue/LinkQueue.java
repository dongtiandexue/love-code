package com.hh.structure.queue;

/**
 * @Description: 基于链表实现链式队列
 * @Author: gorun
 * @date 2020/10/7
 */
public class LinkQueue<T> {

    /**
     * 头指针：指向队首位置
     */
    private Node head;

    /**
     * 尾指针：指向队尾位置
     */
    private Node tail;

    /**
     * 入队操作
     *
     * @param data
     * @return
     */
    public boolean add(T data) {
        Node node = new Node(data, null);
        // 判断队列中是否有元素
        if (tail == null) {
            tail = node;
            head = node;
        } else {
            tail.next = node;
            tail = node;
        }
        return true;
    }

    /**
     * 出队操作
     *
     * @return
     */
    public T dequeue() {
        if (head == null) {
            throw new IndexOutOfBoundsException("Queue empty");
        }

        T data = (T) head.data;
        head = head.next;
        // 取出元素后，头指针为空，说明队列中没有元素，tail也需要制为空
        if (head == null) {
            tail = null;
        }
        return data;
    }

    /**
     * 自定义内部类实现链表节点
     *
     * @param <T>
     */
    class Node<T> {
        private T data;
        private Node next;

        public Node(T data, Node node) {
            this.data = data;
            next = node;
        }
    }
}
