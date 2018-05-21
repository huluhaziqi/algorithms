package lin.java.test.algorithms.dynamic_programming;

import java.util.Arrays;

public class MaximumLengthofPairChain {


    public static void main(String[] args) {

    }
    public int findLongestChain(int[][] pairs) {
        if(pairs == null || pairs.length == 0 || pairs[0].length == 0){
            return 0;
        }
        Arrays.sort(pairs,(int[] o1, int[] o2)-> o1[0] - o2[0]);
        int row = pairs.length;
        int[] dp = new int[row];
        dp[0] = 1;
        int max = 1;
        for(int i = 1; i < row; i++){
            dp[i] = 1;
            for(int j = 0; j < i ;j++){
                if(pairs[j][1] < pairs[i][0]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                    max = Math.max(dp[i],max);
                }
            }
        }
        return max;
    }
}
