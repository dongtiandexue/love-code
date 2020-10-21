package com.gorun.offer.topic33;

import java.util.Arrays;

/**
 * @Version: V1.0.0
 * @Description: TODO
 * @Author: gorun
 * @date 2020/8/31
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[]{5,7,6,9,11,10,8};
        System.out.println(solution.isTree(array));
    }

    public boolean isTree(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        int root = array[array.length - 1];
        int i = 0;
        // 在二叉搜索树中左子树节点的值小于根节点的值
        for (; i < array.length - 1; i++) {
            if (array[i] > root) {
                break;
            }
        }
        int j = i;
        // 在二叉搜索树中右子树节点的值大于根节点的值
        for (; j < array.length - 1; j++) {
            if (array[j] < root) {
                return false;
            }
        }

        boolean left = true;
        // 判断左子树是不是二叉搜索树
        if (i > 0) {
            left = isTree(Arrays.copyOfRange(array, 0, i));
        }
        boolean right = true;
        // 判断右子树是不是二叉搜索树
        if (i < array.length - 1) {
            right = isTree(Arrays.copyOfRange(array, i + 1, array.length - 2));
        }
        return left && right;
    }
}
