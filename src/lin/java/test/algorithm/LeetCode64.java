package lin.java.test.algorithm;

import java.util.Scanner;

public class LeetCode64 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){

            Solution solution = new Solution();
            int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
            int result = solution.minPathSum(grid);
            System.out.println(result);
        }
    }

    static class Solution {
        public int minPathSum(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int[] dp = new int[grid[0].length];
            dp[0] = grid[0][0];
            for (int i = 1; i < grid[0].length; i++) {
                dp[i] = dp[i - 1] + grid[0][i];
            }
            for (int i = 1; i < grid.length; i++) {
                dp[0] = dp[0] + grid[i][0];
                for (int j = 1; j < grid[0].length; j++) {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
                }
            }
            return dp[grid[0].length - 1];
        }
    }
}
