package com.gorun.offer.topic11;

/**
 * @Version: V1.0.0
 * @Description: 旋转数组的最小数字
 * @Author: gorun
 * @date 2020/8/9
 */
public class Solution1 {

    public static void main(String[] args) {
        int[] arr1 = new int[]{3, 4, 5, 1, 2};
        System.out.println(getMinNumber(arr1));

        int[] arr2 = new int[]{1, 0, 1, 1, 1};
        System.out.println(getMinNumber(arr2));
    }

    public static int getMinNumber(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int index1 = 0;
        int index2 = arr.length - 1;
        // 初始化最小数为数组第一个元素，防止该数组是一个有序数组
        int indexMin = index1;
        while (arr[index1] >= arr[index2]) {
            if (index2 - index1 == 1) {
                // 查询终止条件
                indexMin = index2;
                break;
            }
            indexMin = (index1 + index2) >> 1;
            if (arr[index1] == arr[indexMin] && arr[indexMin] == arr[index2]) {
                // 特殊情况下 index1 indexMin index2 下标指向的元素相等，只能采用遍历排序算法
                return minInOrder(arr, index1, index2);
            } else if (arr[indexMin] >= arr[index1]) {
                // 如果中间元素大于指针1指向的元素，表明中间元素一定位于第一个递增子数组，并且最小的数字一定位于它的后面
                index1 = indexMin;
            } else if (arr[indexMin] <= arr[index2]) {
                // 如果中间元素小于指针2指向的元素，表明中间元素一定位于第二个递增子数组，并且最小的数字一定位于它的前面或者就是他自己
                index2 = indexMin;
            }
        }
        return arr[indexMin];
    }

    private static int minInOrder(int[] arr, int index1, int index2) {
        int result = arr[index1];
        for (int i = index1 + 1; i < index2; i++) {
            if(result > arr[i]){
                result = arr[i];
            }
        }
        return result;
    }
}
