package com.hh.algorithm.sort;

/**
 * @Description: 希尔排序
 * 排序算法：
 * 1、希尔排序在每次的排序的时候都把数组拆分成若干个序列，一个序列的相邻的元素索引相隔的固定的距离gap，
 * 2、每一轮对这些序列进行冒泡或者插入排序，然后再缩小`gap`得到新的序列一一排序，直到gap为1
 * @Author: hh
 * @date 2020/10/17
 */
public class ShellSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int gap = arr.length >> 1;
        while (gap > 0) {
            // 对每个子序列进行排序
            for (int i = 0; i < gap; i++) {
                // 插入排序的部分
                for (int j = i + gap; j < arr.length; j += gap) {
                    int temp = j;
                    while (temp > i && arr[temp] < arr[temp - gap]) {
                        swap(arr, temp, temp - gap);
                        temp -= gap;
                    }
                }
            }
            gap >>= 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 4, 3, 1, 2};
        sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
