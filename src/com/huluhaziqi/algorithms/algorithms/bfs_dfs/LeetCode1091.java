package com.huluhaziqi.algorithms.algorithms.bfs_dfs;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1091 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{0}};
        solution.shortestPathBinaryMatrix(grid);
    }

    static class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0 || grid[0][0] == 1) {
                return -1;
            }
            int[][] directions = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
            int len = grid.length;
            int rowLen = grid[0].length;
            boolean[][] visited = new boolean[len][rowLen];
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, 0});
            visited[0][0] = true;
            int result = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();

                while (size-- > 0) {
                    int[] top = queue.poll();
                    if (top[0] == len - 1 && top[1] == len - 1) {
                        return result;
                    }
                    int row = top[0];
                    int col = top[1];
                    grid[row][col] = 1;
                    for (int i = 0; i < 8; i++) {
                        int rowT = row + directions[i][0];
                        int colT = col + directions[i][1];
                        if (rowT >= 0 && rowT < len && colT >= 0 && colT < rowLen && !visited[rowT][colT] && grid[rowT][colT] == 0) {
                            visited[rowT][colT] = true;
                            queue.offer(new int[]{rowT, colT});
                        }

                    }
                }
                result++;
            }
            return -1;
        }

    }
}
