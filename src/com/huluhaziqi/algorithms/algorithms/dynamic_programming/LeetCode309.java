package com.huluhaziqi.algorithms.algorithms.dynamic_programming;

public class LeetCode309 {

    class Solution {
        public int maxProfit(int[] prices) {
            if(prices == null ||prices.length == 0){
                return 0;
            }
            int curSell = 0;
            int preSell = 0;

            int buy = -prices[0];
            for(int i = 1; i <prices.length; i++){
                int tem = curSell;
                curSell = Math.max(curSell , buy +prices[i]);

                buy = Math.max(buy, (i > 1 ? preSell :0 ) - prices[i]);
                preSell = tem;
            }
            return curSell;
        }
    }
}
