package com.huluhaziqi.algorithms.algorithms.dynamic_programming;

public class LeetCode650 {

    /**
     * 650. 2 Keys Keyboard
     * Medium
     *
     * 970
     *
     * 75
     *
     * Add to List
     *
     * Share
     * Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:
     *
     * Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
     * Paste: You can paste the characters which are copied last time.
     *
     *
     * Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.
     *
     * Example 1:
     *
     * Input: 3
     * Output: 3
     * Explanation:
     * Intitally, we have one character 'A'.
     * In step 1, we use Copy All operation.
     * In step 2, we use Paste operation to get 'AA'.
     * In step 3, we use Paste operation to get 'AAA'.
     *
     *
     * Note:
     *
     * The n will be in the range [1, 1000].
     *
     */
    class Solution {
        public int minSteps(int n) {
            if(n <= 1){
                return 0;
            }
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 0;
            int h = (int) Math.sqrt(n);
            for(int i = 2; i <= n; i++){
                dp[i] = i;
                for(int j = 2; j <= h; j++){
                    if( i % j == 0){
                        dp[i] = dp[i / j] + dp[j];
                        break;
                    }
                }
            }
            return dp[n];
        }
    }
}
