package com.huluhaziqi.algorithms.algorithms.dynamic_programming;

public class OnesAndZeros {

    public static void main(String[] args) {
        int m = 5;
        int n = 3;
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int result = new OnesAndZeros().findMaxForm(strs, m, n);
        System.out.println(result);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        if(strs == null || strs.length == 0){
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for(String s : strs){
            int zeros = 0;
            int ones = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '0'){
                    zeros++;
                } else if(s.charAt(i) == '1'){
                    ones++;
                }
            }
            for(int i = m; i >= zeros; i--){
                for(int j = n; j >= ones; j--){
                    dp[i][j] = Math.max(dp[i][j],dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            if(strs == null || strs.length == 0){
                return 0;
            }
            int[][] dp = new int[m + 1][n + 1];
            for(String s : strs){
                int len = s.length();
                int zeros = 0;
                int ones = 0;
                for(int i = 0; i < len ;i++){
                    if(s.charAt(i) == '0'){
                        zeros++;
                    }else if (s.charAt(i) == '1'){
                        ones++;
                    }
                }
                for(int i = m; i>= 0; i--){
                    for(int j = n; j >= 0 ;j--){
                        if(i >= zeros && j >= ones){
                            dp[i][j] = Math.max(dp[i][j],dp[i - zeros][j - ones] + 1);
                        }
                    }
                }
            }
            return dp[m][n];
        }
    }
}
