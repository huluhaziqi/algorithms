package com.huluhaziqi.algorithms.algorithms.twosum;

//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
//
//        示例1:
//
//        输入: 5
//        输出: True
//        解释: 1 * 1 + 2 * 2 = 5

public class LeetCode633 {
    class Solution {
        public boolean judgeSquareSum(int c) {
            if(c < 0){
                return false;
            }
            long i = 0;
            long j = (long) Math.sqrt(c) +1;
            while(i <= j){
                long tem = i * i +j * j ;
                if(tem == c){
                    return true;
                } else if(tem > c){
                    j--;
                } else {
                    i++;
                }
            }
            return false;
        }
    }


}
