package com.gorun.offer.topic3_1;

import java.util.Arrays;

/**
 * @Version: V1.0.0
 * @Description: 找出数组中重复的数字
 * 解法一：对数组进行排序，然后从头到尾扫描排序后的数组
 * 示例：有一个长度为7的重复数组 {0,1,5,2,3,7,4,3} ---> 排序后 {0,1,2,3,3,4,5,7} ---> 遍历数组，下标为 3 和 4 的元素重复了
 * @Author: gorun
 * @date 2020/8/8
 */
public class Solution1 {

    public static void main(String[] args) {
        // 空指针数组
        int[] arr1 = null;
        System.out.println(getRepeatNumber(arr1));

        // 数组中不包含重复的数字
        int[] arr2 = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(getRepeatNumber(arr2));

        // 无效的数组
        int[] arr3 = new int[]{0, 1, 2, 3, 4, 5, 6, 8};
        System.out.println(getRepeatNumber(arr3));

        // 包含一个或多个重复数字的数组
        int[] arr4 = new int[]{0, 1, 5, 2, 3, 7, 4, 3};
        System.out.println(getRepeatNumber(arr4));


    }

    private static int getRepeatNumber(int[] arr) {
        // 判空处理
        int length = 0;
        if (arr == null || (length = arr.length) == 0) {
            return -1;
        }
        Arrays.sort(arr);
        if (arr[length - 1] >= length) {
            // 判断是否是无效的数组
            return -1;
        }
        int temp = arr[0];
        int i = 1;
        for (; i < length; i++) {
            if (arr[i] == temp) {
                break;
            }
            temp = arr[i];
        }
        if (i == length) {
            // 数组中不包含重复的数字
            return -1;
        }
        return arr[i];
    }
}
