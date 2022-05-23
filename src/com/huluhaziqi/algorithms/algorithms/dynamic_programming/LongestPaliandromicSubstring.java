package com.huluhaziqi.algorithms.algorithms.dynamic_programming;

public class LongestPaliandromicSubstring {

    public static void main(String[] args) {
        String s = "cbbc";
        String result = new LongestPaliandromicSubstring().longestPalindrome(s);
        System.out.println(result);
    }

    public  String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int len = s.length();
        if (len == 1) {
            return s;
        }

        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int result = 0;
        int start = 0;
        int end = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && ((i - 1 >= j + 1 && dp[j + 1][i - 1]) || i == j + 1))  {
                    dp[j][i] = true;
                    if (i - j + 1 > result) {
                        result = i - j + 1;
                        start = j;
                        end = i;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return s.substring(start,end + 1);
    }
}
