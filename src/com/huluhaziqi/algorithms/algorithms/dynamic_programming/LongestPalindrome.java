package com.huluhaziqi.algorithms.algorithms.dynamic_programming;

public class LongestPalindrome {

    /**
     * 最长回文子串
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * <p>
     * 示例 1：
     * <p>
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     * <p>
     * 输入: "cbbd"
     * 输出: "bb"
     *
     * @param args
     */
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
                    if (i - j + 1 > max) {
                        start = j;
                        end = i;
                        max = i - j + 1;
                    }
                }
            }
        }
        return s.substring(start, start + max);
    }

    class Solution2 {
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            int len = s.length();
            int max = 1;
            boolean[][] dp = new boolean[len][len];
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }
            int s1 = 0;
            int e1 = 0;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    dp[j][i] = (s.charAt(i) == s.charAt(j)) && (i - j < 2 || dp[j + 1][i - 1]);
                    if (dp[j][i]) {
                        if (i - j + 1 > max) {
                            s1 = j;
                            e1 = i;
                            max = i - j + 1;
                        }
                    }

                }
            }
            return s.substring(s1, s1 + max);

        }


    }
}
