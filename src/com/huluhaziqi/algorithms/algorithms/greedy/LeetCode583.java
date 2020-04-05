package com.huluhaziqi.algorithms.algorithms.greedy;

public class LeetCode583 {

    /**
     * 583. Delete Operation for Two Strings
     * Medium
     *
     * 912
     *
     * 24
     *
     * Add to List
     *
     * Share
     * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.
     *
     * Example 1:
     * Input: "sea", "eat"
     * Output: 2
     * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
     * Note:
     * The length of given words won't exceed 500.
     * Characters in given words can only be lower-case letters.
     * Accepted
     * 43,078
     * Submissions
     * 91,607
     */
    class Solution {
        public int minDistance(String word1, String word2) {
            if (word1 == null || word2 == null) {
                return 0;
            }
            int len1 = word1.length();
            int len2 = word2.length();
            int[][] dp = new int[len1 + 1][len2 + 1];
            for (int i = 1; i <= len1; i++) {
                for (int j = 1; j <= len2; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
            return len1 + len2 - 2 * dp[len1][len2];
        }
    }
}
