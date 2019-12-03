package com.huluhaziqi.algorithms.algorithms.greedy;

public class LeetCode121 {

    /**
     * 121. Best Time to Buy and Sell Stock
     * Easy
     *
     * Share
     * Say you have an array for which the ith element is the price of a given stock on day i.
     *
     * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
     *
     * Note that you cannot sell a stock before you buy one.
     *
     * Example 1:
     *
     * Input: [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     *              Not 7-1 = 6, as selling price needs to be larger than buying price.
     * Example 2:
     *
     * Input: [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     */
    class Solution {
        public int maxProfit(int[] prices) {
            if(prices == null || prices.length < 2){
                return 0;
            }
            int max = 0;
            int tem = 0;
            for(int i = 0; i < prices.length - 1; i++){
                tem += prices[i + 1] - prices[i];
                tem = Math.max(tem, prices[i + 1] - prices[i]);
                max = Math.max(max, tem);
            }
            return max;
        }
    }
    class Solution2 {
        public int maxProfit(int[] prices) {
            if(prices == null || prices.length < 2){
                return 0;
            }
            int[] gap = new int[prices.length - 1];
            for(int i = 0; i < prices.length - 1; i++){
                gap[i] = prices[i + 1] - prices[i];
            }
            int max = 0;
            int start = 0;
            int tem = 0;
            while(start < gap.length) {
                if(gap[start] + tem <= 0){
                    tem = 0;
                } else {
                    tem += gap[start];
                }
                max = Math.max(max, tem);
                start++;
            }
            return max;
        }
    }
}
