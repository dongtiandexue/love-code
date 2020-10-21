package com.gorun.offer.topic3_2;

/**
 * @Version: V1.0.0
 * @Description: 不修改数组找出重复的数字
 * @Author: gorun
 * @date 2020/8/8
 */
public class Solution {

    public static void main(String[] args) {

        // 空指针数组
        int[] arr1 = null;
        System.out.println(getRepeatNumber(arr1));

        // 数组中不包含重复的数字
        int[] arr2 = new int[]{1, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(getRepeatNumber(arr2));

        // 无效的数组
        int[] arr3 = new int[]{0, 1, 2, 3, 4, 5, 6, 8};
        System.out.println(getRepeatNumber(arr3));

        // 包含一个或多个重复数字的数组
        int[] arr4 = new int[]{1, 1, 5, 5, 3, 7, 4, 3};
        System.out.println(getRepeatNumber(arr4));
    }

    private static int getRepeatNumber(int[] arr) {
        int length = 0;
        if (arr == null || (length = arr.length) <= 1) {
            return -1;
        }
        int start = 1;
        int end = length - 1;
        while (end >= start) {
            // 获取中间值
            int middle = ((end - start) >> 1) + start;
            int count = 0;
            for (int i : arr) {
                if (i >= start && i <= middle) {
                    count++;
                }
            }
            if (end == start) {
                // 判断首尾指针相遇的情况
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > (middle - start + 1)) {
                // 如果 start ~ middle 之间元素个数大于 middle - start + 1 说明存在重复元素
                // 注意此方法无法保证 middle 和 end 之间不存在重复元素
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }
}
