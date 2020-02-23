package com.huluhaziqi.algorithms.algorithms.bfs_dfs;

public class FriendCircle {

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        int result = new FriendCircle().findCircleNum(grid);
        System.out.println(result);
    }

    int n;

    public int findCircleNum(int[][] grid) {
        n = grid.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                count += dfs2(grid, i, visited) != 0 ? 1 : 0;
            }
        }
        return count;
    }

    public int dfs2(int[][] grid, int j, boolean[] visited) {
        int count = 1;
        for (int i = 0; i < n; i++) {
            if (grid[j][i] == 1 && visited[i] == false) {
                visited[i] = true;
                count += dfs2(grid, i, visited);
            }
        }
        return count;
    }

    public int findCircleNum2(int[][] M) {
        int len = M.length;
        boolean[] visited = new boolean[len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (visited[i] == false) {
                dfs(M, i, visited);
                count++;
            }
        }
        return count;

    }

    public void dfs(int grid[][], int k, boolean[] visited) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[k][i] == 1 && visited[i] == false) {
                visited[i] = true;
                dfs(grid, i, visited);
            }
        }
    }

    class Solution {
        public int findCircleNum(int[][] M) {
            if (M == null || M.length == 0 || M[0] == null || M[0].length == 0) {
                return 0;
            }
            int count = 0;
            boolean[] visited = new boolean[M.length];
            for (int i = 0; i < M.length; i++) {
                if (!visited[i]) {
                    count += ((dfs(M, i, visited) >= 1) ? 1 : 0);
                }
            }
            return count;
        }


        int dfs(int[][] m, int i, boolean[] visited) {
            int count = 1;
            for (int k = 0; k < m.length; k++) {
                if (!visited[k] && m[i][k] == 1) {
                    visited[k] = true;
                    count += dfs(m, k, visited);
                }
            }
            return count;
        }
    }


}
