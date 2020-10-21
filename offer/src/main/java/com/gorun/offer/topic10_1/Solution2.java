package com.gorun.offer.topic10_1;

/**
 * @Version: V1.0.0
 * @Description: 斐波那契数列
 * 递归法求解：递归法解决斐波那契数列随着n值的增大存在严重的效率问题，会存在大量的重复计算
 * @Author: gorun
 * @date 2020/8/8
 */
public class Solution2 {

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
        int first = 0;
        int second = 1;
        int result = first + second;
        for (int i = 2; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;

        }
        return result;
    }
}
