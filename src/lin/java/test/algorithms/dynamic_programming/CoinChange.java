package lin.java.test.algorithms.dynamic_programming;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount =11;
        int result = new CoinChange().coinChange(coins,amount);
        System.out.println(result);
    }
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0){
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int c :coins){
                if(i >= c){
                    dp[i] = Math.min(dp[i],dp[i - c] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    class Solution {
        public int coinChange(int[] coins, int amount) {
            if(coins == null || coins.length == 0){
                return 0;
            }
            int len = coins.length;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp,amount + 1);
            dp[0] = 0;
            for(int i = 1; i<= amount; i++){
                for(int c : coins){
                    if(i >= c){
                        dp[i] = Math.min(dp[i],dp[i - c] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
}
