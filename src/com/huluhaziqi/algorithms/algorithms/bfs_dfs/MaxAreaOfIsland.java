package com.huluhaziqi.algorithms.algorithms.bfs_dfs;

import javafx.util.Pair;

import java.util.Stack;

public class MaxAreaOfIsland {

    int[][] direction2 = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        int reuslt = new MaxAreaOfIsland().maxAreaOfIsland4(grid);
        System.out.println(reuslt);
    }

    public int maxAreaOfIsland2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, dfs2(grid, i, j));
            }
        }
        return max;
    }

    public int dfs2(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int count = 1;
        for (int[] d : direction2) {
            count += dfs2(grid, i + d[0], j + d[1]);
        }
        return count;
    }

    int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(dfs(grid, i, j, visited), max);
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (grid == null || grid.length == 0 || i >= grid.length || i < 0 || j >= grid[0].length ||
                j < 0 || visited[i][j] == true || grid[i][j] == 0) {
            return 0;
        }
        int count = 1;
        for (int d[] : direction) {
            visited[i][j] = true;
            count += dfs(grid, i + d[0], j + d[1], visited);
        }
        return count;
    }

    class Solution1 {
        public int maxAreaOfIsland(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
                return 0;
            }
            int row = grid.length;
            int col = grid[0].length;
            boolean[][] visited = new boolean[row][col];
            int max = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    max = Math.max(dfs(grid, i, j), max);
                }
            }
            return max;
        }

        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int dfs(int[][] grid, int i, int j) {
            if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == 0) {
                return 0;
            }
            grid[i][j] = 0;
            int count = 1;
            for (int[] d : direction) {
                count += dfs(grid, i + d[0], j + d[1]);
            }
            return count;
        }
    }

    public int maxAreaOfIsland4(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int area = 0;
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                int cur = 0;
                stack.push(new Pair<>(i,j));
                while(!stack.isEmpty()){
                    Pair top = stack.pop();
                    cur++;
                    int x1 = (int)top.getKey() ;
                    int y1 = (int)top.getValue();
                    if(x1 < 0 || x1 >= grid.length || y1 < 0 || y1 >= grid.length ||grid[x1][y1] == 0){
                        continue;
                    }
                    grid[x1][y1] = 0;
                    for(int k = 0; k < 4; k++){
                        int x2 = x1 + dir[k][0];
                        int y2 = y1 + dir[k][1];
                        stack.push(new Pair<>(x2,y2));
                    }
                }
                System.out.println(" cur " + cur);
                area = Math.max(area, cur);
            }
        }
        return area;
    }

    int[][] dir = {{0, 1},{ 1,0},{ -1, 0},{0, -1}};
}
