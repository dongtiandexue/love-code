package com.hh.algorithm.sort;

/**
 * @Description: 归并排序
 * 排序算法：
 * 1、把原来的数组变成左右两个数组，然后分别进行排序
 * 2、当左右的子数组排序完毕之后，再合并这两个子数组形成一个新的排序数组
 * 3、重复上述步骤，直到所有元素有序
 * @Author: hh
 * @date 2020/10/17
 */
public class MergeSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        merge(arr, 0, arr.length);
    }

    public static void merge(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >>> 1;

        // 先对左右子数组进行排序
        merge(arr, left, mid);
        merge(arr, mid + 1, right);

        // 临时数组存放合并结果
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1;
        int cur = 0;
        // 开始合并数组
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[cur] = arr[i++];
            } else {
                temp[cur] = arr[j++];
            }
            cur++;
        }
        while (i <= mid) {
            temp[cur++] = arr[i++];
        }
        while (j <= right) {
            temp[cur++] = arr[j++];
        }

        // 合并数组完成，拷贝到原来的数组中
        for (int k = 0; k < temp.length; k++) {
            arr[left + k] = temp[k];
        }


    }
}
