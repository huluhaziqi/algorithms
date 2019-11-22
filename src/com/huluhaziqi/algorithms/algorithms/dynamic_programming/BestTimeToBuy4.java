package com.huluhaziqi.algorithms.algorithms.dynamic_programming;

public class BestTimeToBuy4 {

    public static void main(String[] args) {
        int[] prices = {2,4,1};
        int k = 2;
        int result = new BestTimeToBuy4().maxProfit(k,prices);
        System.out.println(result);
    }

    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length <= 1 || k <= 0){
            return 0;
        }
        if(k > prices.length){
            k = prices.length;
        }
        int len = prices.length;
        int[] local = new int[k + 1];
        int[] global = new int[k + 1];
        for(int i = 1; i < len; i++){
            for(int j= k; j >= 1; j--){
                local[j] = Math.max(global[j - 1] + Math.max(prices[i] - prices[i - 1],0),
                        local[j] + prices[i] - prices[i - 1]);
                global[j] = Math.max(local[j],global[j]);
            }
        }
        return global[k];

    }
}
