package lin.java.test.dynamic_programming;

public class UniquePathsWithObstables {
    public static void main(String[] args) {
        int[][] obstableGrid = {{0}, {1}};
        int result = new UniquePathsWithObstables().uniquePathsWithObstacles(obstableGrid);
        System.out.println(result);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int max = Integer.MAX_VALUE;
        int[] dp = new int[obstacleGrid[0].length];
        dp[0] = obstacleGrid[0][0] == 1 ? max : 1;
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            dp[i] = (obstacleGrid[0][i] == 1 || dp[i - 1] == max) ? max : 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 0) {
                    if (dp[j] != max && j - 1 >= 0 && dp[j - 1] != max) {
                        dp[j] = dp[j] + dp[j - 1];
                    } else if (dp[j] != max) {
                        dp[j] = dp[j];
                    } else if (j - 1 >= 0 && dp[j - 1] != max) {
                        dp[j] = dp[j - 1];
                    }
                } else {
                    dp[j] = max;
                }
            }
        }
        return dp[obstacleGrid[0].length - 1] == max ? 0 : dp[obstacleGrid[0].length - 1];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int len = obstacleGrid[0].length;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < len; j++) {
                if (row[j] == 1) {
                    dp[j] = 0;
                } else if (j >= 1) {
                    dp[j] = dp[j] + dp[j - 1];
                } else if (j == 0) {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[len - 1];
    }
}
