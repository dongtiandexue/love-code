package com.gorun.offer.topic16;

/**
 * @Version: V1.0.0
 * @Description: 数值的整数次方
 * 需要考虑边界问题
 * @Author: gorun
 * @date 2020/8/15
 */
public class Solution {


    public double power(double base, int exponent) {
        if (base == 0.0 && exponent < 0) {
            return 0;
        }
        int absExponent = Math.abs(exponent);

        double result = powerWithExponent(base, absExponent);
        if (exponent < 0) {
            result = 1.0 / result;
        }
        return result;
    }

    private double powerWithExponent(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double result = powerWithExponent(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) {
            result *= base;
        }
        return result;
    }


    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.power(10, 2));
    }


}
