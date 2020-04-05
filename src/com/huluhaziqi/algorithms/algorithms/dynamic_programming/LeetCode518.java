package com.huluhaziqi.algorithms.algorithms.dynamic_programming;

public class LeetCode518 {

    class Solution {
        public int change(int amount, int[] coins) {
            if (coins == null) {
                return 0;
            }
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for (int c : coins) {
                for (int i = c; i <= amount; i++) {
                    dp[i] += dp[i - c];
                }
            }
            return dp[amount];
        }

    }
}
