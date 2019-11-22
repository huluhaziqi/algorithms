package com.huluhaziqi.algorithms.algorithms.dynamic_programming;

public class Ksnapsack {

    public int knapsack2(int W, int N, int[] weights, int[] values) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];
            for (int j = 1; j <= W; j++) {
                if (j >= w) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][W];
    }



    public int knapsack(int W,int N, int[] weights,int[] values){
        int[][] dp = new int[N + 1][W + 1];
        for(int i = 1; i <= N; i++){
            int w = weights[i];
            int v = values[i];
            for(int j = 1; j <= W;j++){
                if(j>= w){
                    dp[i][j] = Math.max(dp[i - 1][j - w] + v,dp[i - 1][j]);
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][W];
    }

    public int knapsack3(int W,int N, int[] weights,int[] values){
        int[] dp = new int[W + 1];
        for(int i = 1; i <= N; i++){
            int w = weights[i];
            int v = values[i];
            for(int j = 1; j <= W;j++){
                if(j>= w){
                    dp[j] = Math.max(dp[j - w] + v,dp[j]);
                }
            }
        }
        return dp[W];
    }
}
