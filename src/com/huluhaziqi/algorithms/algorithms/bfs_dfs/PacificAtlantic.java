package com.huluhaziqi.algorithms.algorithms.bfs_dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlantic {

    /** leetcode 417
     * 417. Pacific Atlantic Water Flow
     * Medium
     * <p>
     * 967
     * <p>
     * 184
     * <p>
     * Add to List
     * <p>
     * Share
     * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
     * <p>
     * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
     * <p>
     * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
     * <p>
     * Note:
     * <p>
     * The order of returned grid coordinates does not matter.
     * Both m and n are less than 150.
     * <p>
     * <p>
     * Example:
     * <p>
     * Given the following 5x5 matrix:
     * <p>
     * Pacific ~   ~   ~   ~   ~
     * ~  1   2   2   3  (5) *
     * ~  3   2   3  (4) (4) *
     * ~  2   4  (5)  3   1  *
     * ~ (6) (7)  1   4   5  *
     * ~ (5)  1   1   2   4  *
     * *   *   *   *   * Atlantic
     * <p>
     * Return:
     * <p>
     * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        List<int[]> result = new PacificAtlantic().pacificAtlantic(matrix);
        for (int[] r : result) {
            for (int i : r) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }

    int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] p = new boolean[row][col];
        boolean[][] a = new boolean[row][col];
        for (int i = 0; i < col; i++) {
            dfs(matrix, 0, i, p);
            dfs(matrix, row - 1, i, a);
        }

        for (int j = 0; j < row; j++) {
            dfs(matrix, j, 0, p);
            dfs(matrix, j, col - 1, a);
        }
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (p[i][j] && a[i][j]) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }

    public void dfs(int[][] matrix, int i, int j, boolean[][] visited) {
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        for (int[] d : direct) {
            if (i + d[0] < 0 || i + d[0] >= matrix.length || j + d[1] < 0 || j + d[1] >= matrix[0].length || matrix[i][j] > matrix[i + d[0]][j + d[1]]) {
                continue;
            }
            dfs(matrix, i + d[0], j + d[1], visited);
        }
    }

    class Solution {
        public List<List<Integer>> pacificAtlantic(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
                return new ArrayList<>();
            }
            List<List<Integer>> result = new ArrayList<>();
            int row = matrix.length;
            int col = matrix[0].length;
            boolean[][] reacha = new boolean[row][col];
            boolean[][] reachb = new boolean[row][col];
            for (int i = 0; i < row; i++) {
                dfs(matrix, reacha, i, 0);
                dfs(matrix, reachb, i, col - 1);

            }
            for (int i = 0; i < col; i++) {
                dfs(matrix, reacha, 0, i);
                dfs(matrix, reachb, row - 1, i);
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (reacha[i][j] && reachb[i][j]) {
                        result.add(Arrays.asList(i, j));
                    }
                }
            }
            return result;
        }

        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        void dfs(int[][] matrix, boolean[][] reach, int i, int j) {
            if (reach[i][j]) {
                return;
            }
            reach[i][j] = true;
            for (int[] d : direction) {
                int tem1 = i + d[0];
                int tem2 = j + d[1];
                if (tem1 < 0 || tem1 > matrix.length - 1 || tem2 < 0 || tem2 > matrix[0].length - 1 || matrix[i][j] > matrix[tem1][tem2])
                    continue;
                dfs(matrix, reach, tem1, tem2);
            }
        }
    }

}
