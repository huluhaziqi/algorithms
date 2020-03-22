package com.huluhaziqi.algorithms.algorithms.greedy;

public class Leetcode188 {

    /**
     * leetcode 188
     * 188. Best Time to Buy and Sell Stock IV
     * Hard
     * <p>
     * 1174
     * <p>
     * 73
     * <p>
     * Add to List
     * <p>
     * Share
     * Say you have an array for which the i-th element is the price of a given stock on day i.
     * <p>
     * Design an algorithm to find the maximum profit. You may complete at most k transactions.
     * <p>
     * Note:
     * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     * <p>
     * Example 1:
     * <p>
     * Input: [2,4,1], k = 2
     * Output: 2
     * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
     * Example 2:
     * <p>
     * Input: [3,2,6,5,0,3], k = 2
     * Output: 7
     * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
     * Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
     * Accepted
     * 114,642
     * Submissions
     * 416,359
     */
    // 超时，空间优化
    class Solution {
        public int maxProfit(int k, int[] prices) {
            if (prices == null || prices.length <= 1 || k == 0) {
                return 0;
            }
            if (k > prices.length) {
                k = prices.length;
            }
            int len = prices.length;
            int[][] local = new int[len][k + 1];
            int[][] global = new int[len][k + 1];
            for (int i = 1; i < len; i++) {
                int diff = prices[i] - prices[i - 1];
                for (int j = 1; j <= k; j++) {
                    local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(diff, 0), local[i - 1][j] + diff);
                    global[i][j] = Math.max(local[i][j], global[i - 1][j]);
                }
            }
            return global[len - 1][k];
        }
    }

    class Solution2 {
        public int maxProfit(int k, int[] prices) {
            if (prices == null || prices.length <= 1 || k == 0) {
                return 0;
            }
            if (k > prices.length) {
                k = prices.length;
            }
            int len = prices.length;
            int[] local = new int[k + 1];
            int[] global = new int[k + 1];
            for (int i = 1; i < len; i++) {
                int diff = prices[i] - prices[i - 1];
                for (int j = k; j >= 1; j--) {
                    local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
                    global[j] = Math.max(local[j], global[j]);
                }
            }
            return global[k];
        }
    }
}
