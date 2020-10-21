package com.gorun.offer.topic17;

/**
 * @Version: V1.0.0
 * @Description: 打印1到最大的n位数
 * @Author: gorun
 * @date 2020/8/15
 */
public class Solution {

    public void printMaxNum(int n) {
        if (n <= 0) {
            return;
        }
        double maxNum = Math.pow(10, n) - 1;
        System.out.println("输入 " + n + "得到最大位数 " + maxNum);
        for (int i = 1; i <= maxNum; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.printMaxNum(2);
    }
}
