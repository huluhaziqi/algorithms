package com.huluhaziqi.algorithms.algorithms.bfs_dfs;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlantic {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<int[]> result = new PacificAtlantic().pacificAtlantic(matrix);
        for(int[] r : result){
            for (int i : r) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }

    int[][] direct = {{0, 1},{0, -1}, {1, 0}, {-1, 0}};

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
            if (i + d[0] < 0 || i + d[0] >= matrix.length || j +d[1] < 0 || j + d[1] >= matrix[0].length || matrix[i][j] > matrix[i + d[0]][j + d[1]]) {
                continue;
            }
            dfs(matrix, i + d[0], j + d[1], visited);
        }
    }

}
