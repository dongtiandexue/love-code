package com.gorun.offer.topic10_1;

/**
 * @Version: V1.0.0
 * @Description: 斐波那契数列
 * 递归法求解：递归法解决斐波那契数列随着n值的增大存在严重的效率问题，会存在大量的重复计算
 * @Author: gorun
 * @date 2020/8/8
 */
public class Solution1 {

    public static void main(String[] args) {
        System.out.println(fib(50));
    }

    public static int fib(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
