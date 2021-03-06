package com.huluhaziqi.algorithms.algorithms.dynamic_programming;

public class UniquePaths {

    public static void main(String[] args) {
        int m = 3;
        int n =2;
        int result = new UniquePaths().uniquePaths(m,n);
        System.out.println(result);
    }

    public int uniquePaths(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
