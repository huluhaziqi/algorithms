package com.huluhaziqi.algorithms.algorithms.dynamic_programming;

public class LeetCode714 {

    /**
     * 714. Best Time to Buy and Sell Stock with Transaction Fee
     * Medium
     * <p>
     * 1308
     * <p>
     * 38
     * <p>
     * Add to List
     * <p>
     * Share
     * Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.
     * <p>
     * You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)
     * <p>
     * Return the maximum profit you can make.
     * <p>
     * Example 1:
     * Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
     * Output: 8
     * Explanation: The maximum profit can be achieved by:
     * Buying at prices[0] = 1
     * Selling at prices[3] = 8
     * Buying at prices[4] = 4
     * Selling at prices[5] = 9
     * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
     * Note:
     * <p>
     * 0 < prices.length <= 50000.
     * 0 < prices[i] < 50000.
     * 0 <= fee < 50000.
     * Accepted
     * 59,615
     * Submissions
     * 111,631
     */
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int n = prices.length;
            int[] a = new int[n];
            int[] b = new int[n];
            b[0] = -prices[0];
            for (int i = 1; i < n; i++) {
                a[i] = Math.max(a[i - 1], b[i - 1] + prices[i] - fee);
                b[i] = Math.max(b[i - 1], a[i - 1] - prices[i]);
            }
            return a[n - 1];
        }
    }
}