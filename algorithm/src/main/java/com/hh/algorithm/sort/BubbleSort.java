package com.hh.algorithm.sort;

/**
 * @Description: 冒泡排序算法
 * 算法思路:
 * 1、比较相邻的两个元素，如果第一个比第二个大，就交换他们两个
 * 2、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。最后的会是最大的数
 * 3、针对剩下的元素重复以上步骤，每次得到最大元素，直到没有任何一对数字需要比较
 * @Author: hh
 * @date 2020/10/17
 */
public class BubbleSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{11,1,5,51,66,9};
        sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
