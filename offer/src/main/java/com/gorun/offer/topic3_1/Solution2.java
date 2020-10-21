package com.gorun.offer.topic3_1;

import java.util.HashSet;

/**
 * @Version: V1.0.0
 * @Description: 找出数组中重复的数字
 * 解法二：遍历数组放入哈希表中，如果哈希表中不存在放入哈希表中，如果已存在表明该元素是重复元素
 * @Author: gorun
 * @date 2020/8/8
 */
public class Solution2 {

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
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (i >= length) {
                return -1;
            }
            if (set.contains(i)) {
                return i;
            }
            set.add(i);
        }
        return -1;
    }
}
