package com.hh.algorithm;

/**
 * @Description: TODO
 * @Author: gorun
 * @date 2020/9/22
 */
public class CountNumber {

    public static void main(String[] args) {
        CountNumber countNumber = new CountNumber();
        System.out.println(countNumber.count(100));
    }

    public int count(int number) {
        int res = 0;
        for (int i = 1; i <= number; i++) {
            res += i;
        }
        return res;
    }

    int cal(int n) {
        int ret = 0;
        int i = 1;
        for (; i < n; ++i) {
            ret = ret + f(i);
        }
        return ret;
    }

    int f(int n) {
        int sum = 0;
        int i = 1;
        for (; i < n; ++i) {
            sum = sum + i;
        }
        return sum;
    }
}
