package com.hh.structure.queue;

/**
 * @Description: 基于数组实现的循环队列
 * @Author: gorun
 * @date 2020/10/7
 */
public class ArrayCycleQueue<T> {

    /**
     * 存放数据的数组
     */
    private T[] items;

    /**
     * 容器大小
     */
    private int capacity = 0;

    /**
     * 头指针：指向队列的第一个元素
     */
    private int head = 0;

    /**
     * 尾指针：指向队列的最后一个元素
     */
    private int tail = 0;

    /**
     * 构造函数
     *
     * @param capacity 初始化容器大小
     */
    public ArrayCycleQueue(int capacity) {
        this.capacity = capacity + 1;
        items = (T[]) new Object[capacity + 1];
    }

    /**
     * 入队操作
     *
     * @param data 添加元素
     * @return true:入队成功；false：入队失败
     */
    public boolean add(T data) {

        items[tail] = data;
        int newtail = (tail + 1) % capacity;
        if (newtail == head) {
            throw new IndexOutOfBoundsException("Queue full");
        }
        tail = newtail;
        return true;
    }

    /**
     * 出队操作
     *
     * @return
     */
    public T get() {
        // 第一个元素和最后一个元素相等时，队列为空
        if (head == tail) {
            throw new IndexOutOfBoundsException("Queue empty");
        }

        T result = items[head];
        // 将队首元素置为null，释放内存
        items[head] = null;
        // 因为是环形队列，所以下边是数组长度的余数
        head = (head + 1) % capacity;
        return result;
    }
}
