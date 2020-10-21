package com.gorun.offer.topic5;

/**
 * @Version: V1.0.0
 * @Description: 替换空格
 * @Author: gorun
 * @date 2020/8/24
 */
public class Solution {

    public static void main(String[] args) {
        String s = "Hello World   ";
        Solution solution = new Solution();
        System.out.println(solution.replaceSpace(s));
    }
    public String replaceSpace(String s) {
        return s.replaceAll(" ","%20");
    }
}
