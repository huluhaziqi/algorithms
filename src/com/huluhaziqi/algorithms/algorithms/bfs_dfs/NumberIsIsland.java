package com.huluhaziqi.algorithms.algorithms.bfs_dfs;

public class NumberIsIsland {

    public static void main(String[] args) {
        int[][] m = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        int result = new NumberIsIsland().findCircleNum(m);
        System.out.println(result);
    }

    int[][] direction = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result += dfs2(grid, i, j) != 0 ? 1 : 0;
            }
        }
        return result;
    }

    int dfs2(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return 0;
        }
        grid[i][j] = '0';
        int count = 1;
        for (int[] d : direction) {
            count += dfs2(grid, i + d[0], j + d[1]);
        }
        return count;
    }

    int n;

    public int findCircleNum(int[][] M) {
        n = M.length;
        int circleNum = 0;
        boolean[] hasVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!hasVisited[i]) {
                dfs(M, i, hasVisited);
                circleNum++;
            }
        }

        return circleNum;
    }

    private void dfs(int[][] M, int i, boolean[] hasVisited) {
        hasVisited[i] = true;
        for (int k = 0; k < n; k++)
            if (M[i][k] == 1 && !hasVisited[k])
                dfs(M, k, hasVisited);
    }


    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (grid == null || grid.length == 0 || grid[0].length == 0 ||
                i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        for (int[] d : direction) {
            grid[i][j] = '0';
            dfs(grid, i + d[0], j + d[1]);
        }
    }

    class Solution {
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
                return 0;
            }
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);
                        count++;
                    }
                }
            }
            return count;
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        void dfs(char[][] grid, int i, int j) {
            if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == '0') {
                return;
            }
            grid[i][j] = '0';
            for (int[] d : directions) {
                dfs(grid, i + d[0], j + d[1]);
            }
        }
    }
}
