package lin.java.test.algorithms.dynamic_programming;

public class MaximalSquare {
    public static void main(String[] args) {
//        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        char[][] matrix = {{'1','0',},{'1','1'}};
        int result = new MaximalSquare().maximalSquare3(matrix);
        System.out.println(result);
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    int slen = 1;
                    boolean flag = true;//是
                    while (slen + i < row && slen + j < col && flag) {
                        for (int x = i; x <= slen + i; x++) {
                            if (matrix[x][j + slen] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        for (int x = j; x <= slen + j; x++) {
                            if (matrix[i + slen][x] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            slen++;
                        }
                    }
                    max = Math.max(slen, max);
                }
            }
        }
        return max * max;
    }

    public int maximalSquare2(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int max = 0;
        for (int i = 0; i < row; i++) {
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(dp[i][0], max);
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else if (i >= 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                } else {
                    dp[i][j] = matrix[i][j] - '0';
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }


    public int maximalSquare3(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int max = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (i >= 1 && j >= 1) {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    } else {
                        dp[i][j] = matrix[i][j] - '0';
                    }
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}
