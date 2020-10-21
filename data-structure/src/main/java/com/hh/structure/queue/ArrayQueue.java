package com.hh.structure.queue;

/**
 * @Description: 基于数组实现的顺序队列
 * @Author: gorun
 * @date 2020/10/7
 */
public class ArrayQueue<T> {

    /**
     * 存放数据的数组
     */
    private T[] items;

    /**
     * 容器大小
     */
    private int size = 0;

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
     * @param size 初始化容器大小
     */
    public ArrayQueue(int size) {
        this.size = size;
        items = (T[]) new Object[size];
    }

    /**
     * 入队操作
     *
     * @param data 添加元素
     * @return true:入队成功；false：入队失败
     */
    public boolean add(T data) {

        // 判断队列满了的条件，tail = size,head = 0
        if (tail == size && head == 0) {
            throw new IndexOutOfBoundsException("Queue full");
        }

        // 如果tail = size，但是head != 0,说明前有数据删除，队列未满，需要数据迁移
        if (tail == size) {
            // head 后面的数据都需要往前迁移 head 位
            for (int i = head; i < size; i++) {
                items[i - head] = items[i];
            }
            // 将尾指针向前移动 head 位
            tail -= head;
            // 将头指针指向 0 位
            head = 0;
        }

        // 向队列中添加元素
        items[tail++] = data;
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
            return null;
        }

        // 头指针向后移动一位，这样做的好处是在出队时不需要数据迁移
        T result = items[head++];
        return result;
    }
}
