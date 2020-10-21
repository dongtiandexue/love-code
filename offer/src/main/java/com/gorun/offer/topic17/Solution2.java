package com.gorun.offer.topic17;

/**
 * @Version: V1.0.0
 * @Description: 打印1到最大的n位数
 * @Author: gorun
 * @date 2020/8/15
 */
public class Solution2 {

    public void printMaxNum(int n) {
        if (n <= 0) {
            return;
        }
        char[] numbers = new char[n+1];
        numbers[n] = '\0';
        int index = 0;
        while (index <= (n-1)){
            if(index == (n-1)){

            }
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        solution.printMaxNum(2);
    }
}
