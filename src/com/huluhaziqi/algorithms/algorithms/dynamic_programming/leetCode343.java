package com.huluhaziqi.algorithms.algorithms.dynamic_programming;

public class leetCode343 {

    class Solution {
        public int integerBreak(int n) {
            if (n <= 1) {
                return 0;
            }
            int[] dp = new int[n + 1];
            dp[0] = dp[1] = 0;
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i - 1; j++) {
                    dp[i] = Math.max(Math.max(dp[i - j] * j, j * (i - j)), dp[i]);
                }
            }
            return dp[n];
        }
    }
}
