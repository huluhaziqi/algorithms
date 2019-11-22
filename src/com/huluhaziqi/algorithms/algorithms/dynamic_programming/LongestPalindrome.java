package com.huluhaziqi.algorithms.algorithms.dynamic_programming;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "1";
        String sub = new LongestPalindrome().longestPalindrome(s);
        System.out.println(sub);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int len = s.length();
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        int start = 0;
        int end = len - 1;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int max = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (chars[i] == chars[j]) {
                    if (j + 1 == i) {
                        dp[j][i] = true;
                    } else {
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                }
                if (dp[j][i] == true) {
                    if(i - j + 1 > max) {
                        start = j;
                        end = i;
                        max = i - j + 1;
                    }
                }
            }
        }
        return s.substring(start, start + max);
    }
}
