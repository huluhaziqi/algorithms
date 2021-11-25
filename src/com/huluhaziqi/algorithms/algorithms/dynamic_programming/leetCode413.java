package com.huluhaziqi.algorithms.algorithms.dynamic_programming;

public class leetCode413 {

    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }
            int len = nums.length;
            int[] dp = new int[len];
            int res = 0;
            for(int i = 2; i < len; i++){
                if(nums[i - 1] - nums[i] == nums[i - 2] - nums[i - 1]){
                    dp[i] = dp[i-1] + 1;
                }
            }
            for(int i = 0 ; i < len; i++){
                res += dp[i];
            }
            return res;

        }
    }
}
