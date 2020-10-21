package com.hh.algorithm.sort;

/**
 * @Description: 选择排序
 * 算法思路：
 * 1、首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
 * 2、再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 3、重复第二步，直到所有元素均排序完毕。
 * @Author: hh
 * @date 2020/10/17
 */
public class SelectionSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }
            if (min != i) {
                // 将找到的最小值和i位置所在的值进行交换
                swap(arr, min, i);
            }
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{11, 1, 5, 51, 66, 9};
        sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
