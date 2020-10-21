package com.gorun.offer.topic14;

/**
 * @Version: V1.0.0
 * @Description: 剪绳子问题
 * @Author: gorun
 * @date 2020/8/12
 */
public class Solution {

    public int cuttingRope(int n) {

        if(n <= 1){
            return -1;
        }
        if(n == 2){
            return 1;
        }
        if( n == 3){
            return 2;
        }
        int[] products = new int[n +1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        for (int i = 4; i <= n; i++) {
            max = 0;
            for (int j = 1; j <= i >> 1; j++) {
                int product = products[j] * products[i-j];
                if(max < product){
                    max = product;
                }
            }
            products[i] = max;
        }
        max = products[n];
        products = null;
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(8));
    }
}
