package com.hh.structure.queue;

/**
 * @Description: 双端队列
 * @Author: gorun
 * @date 2020/10/7
 */
public class DoubleLinkQueue<T> {

    public static void main(String[] args) {
        DoubleLinkQueue<Integer> doubleLinkQueue = new DoubleLinkQueue<Integer>();
        doubleLinkQueue.addFirst(1);
        doubleLinkQueue.addFirst(2);
        doubleLinkQueue.addFirst(3);
        doubleLinkQueue.addFirst(4);
        doubleLinkQueue.addFirst(5);
        doubleLinkQueue.displayAll();
        System.out.println(doubleLinkQueue.getLast());
        System.out.println(doubleLinkQueue.getLast());
        System.out.println(doubleLinkQueue.getLast());
        System.out.println(doubleLinkQueue.getLast());
        System.out.println(doubleLinkQueue.getLast());
        System.out.println(doubleLinkQueue.getLast());
    }

    /**
     * 头指针：指向队首位置
     */
    private Node head;

    /**
     * 尾指针：指向队尾位置
     */
    private Node tail;

    /**
     * 在第一个节点前面入队
     */
    public boolean addFirst(T data) {
        final Node next = head;
        final Node newNode = new Node(null, data, next);
        // 第一个节点指向新节点
        head = newNode;
        if (next == null) {
            // 最后一个节点也指向该节点
            tail = newNode;
        } else {
            // 当前节点的前节点指向新节点
            next.prev = newNode;
        }
        return true;

    }

    /**
     * 在最后一个元素后面入队
     *
     * @param data
     * @return
     */
    public boolean addLast(T data) {
        final Node prev = tail;
        final Node newNode = new Node(prev, data, null);
        // 最后一个节点指向新节点
        tail = newNode;
        if (prev == null) {
            // 第一个节点指向新节点
            head = newNode;
        } else {
            // 当前节点的下节点指向新节点
            prev.next = newNode;
        }
        return true;

    }

    /**
     * 从第一个节点出队
     *
     * @return
     */
    public T getFirst() {
        if (head == null) {
            throw new IndexOutOfBoundsException("Queue empty");
        }
        final Node node = head;
        T data = (T) node.data;
        // 第一个节点指向当先节点的next节点
        head = head.next;
        if (head == null) {
            // 说明队列为空
            tail = null;
        } else {
            head.prev = null;
        }
        return data;
    }

    /**
     * 从最后节点出队
     *
     * @return
     */
    public T getLast() {
        if (tail == null) {
            throw new IndexOutOfBoundsException("Queue empty");
        }
        final Node node = tail;
        T data = (T) node.data;
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }

        return data;
    }

    /**
     * 输出队列全部内容
     */
    public void displayAll() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("===============");
    }

    /**
     * 自定义内部实现双向链表
     *
     * @param <T>
     */
    private static class Node<T> {
        T data;
        Node next;
        Node prev;

        Node(Node prev, T data, Node next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}
