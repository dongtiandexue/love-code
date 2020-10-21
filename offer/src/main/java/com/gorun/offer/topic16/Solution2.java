package com.gorun.offer.topic16;

/**
 * @Version: V1.0.0
 * @Description: 数值的整数次方
 * 需要考虑边界问题
 * @Author: gorun
 * @date 2020/8/15
 */
public class Solution2 {


    public double power(double x, int n) {
        if(x == 0) {
            return 0;
        }
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                // 这一句代码是关键，如果b位奇数那么第一次循环就会执行 res *= x
                // 不管b是奇数还是偶数，最终会再次执行 res *= x
                res *= x;
            }
            x *= x;
            b >>= 1;

        }
        return res;
    }



    public static void main(String[] args) {

        Solution2 solution = new Solution2();
        System.out.println(solution.power(10, 5));
    }


}
