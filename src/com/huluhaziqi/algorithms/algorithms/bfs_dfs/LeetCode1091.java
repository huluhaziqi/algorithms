package com.huluhaziqi.algorithms.algorithms.bfs_dfs;

import javafx.util.Pair;

import java.util.*;

public class LeetCode1091 {

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[][] grid = {{0}};
//        solution.shortestPathBinaryMatrix(grid);
        // [[0,1,0,0,1,1,0],[1,0,0,0,0,0,0],[1,0,0,1,1,1,1],[0,1,0,0,0,0,0],[1,0,0,0,0,0,1],[1,0,0,1,0,0,0],[1,0,1,0,0,1,0]]
        Solution4 solution4 = new Solution4();
//        int[][] grid = {{0, 1, 0, 0, 1, 1, 0}, {1, 0, 0, 0, 0, 0, 0}, {1, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 0, 0, 0, 0}, {1, 0, 0, 0, 0, 0, 1}, {1, 0, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1, 0}};
        int[][] grid = {{0,0,0}, {1,1,0}, {1,1,1}};
        int result = solution4.shortestPathBinaryMatrix(grid);
        System.out.println(result);
    }

    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0 ||
                    grid[0][0] == 1) {
                return -1;
            }
            int row = grid.length;
            int col = grid[0].length;
            int[][] direction = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {0, -1}, {1, 0}, {1, -1}, {1, 1}};
            boolean[][] visited = new boolean[row][col];
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, 0});
            int min = Integer.MAX_VALUE;
            int step = 1;
            visited[0][0] = true;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    int[] top = queue.poll();
                    if (top[0] == row - 1 && top[1] == col - 1) {
                        return step;
                    }
                    for (int[] d : direction) {
                        int tem1 = top[0] + d[0];
                        int tem2 = top[1] + d[1];
                        if (tem1 < 0 || tem1 >= row || tem2 < 0 || tem2 >= col || grid[tem1][tem2] == 1 || visited[tem1][tem2]) {
                            continue;
                        }
                        visited[tem1][tem2] = true;
                        queue.offer(new int[]{tem1, tem2});
                    }
                }
                step++;
            }
            return -1;
        }

    }

    static class Solution3 {
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

    /**
     * 超时
     */
    static class Solution2 {
        public int shortestPathBinaryMatrix(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
                return -1;
            }
            int row = grid.length;
            int col = grid[0].length;
            boolean[][] visited = new boolean[row][col];
            if (grid[0][0] == 1) {
                return -1;
            }
            List<Integer> start = new ArrayList<>();
            start.add(grid[0][0]);
            visited[0][0] = true;
            bfs(grid, visited, start, 0, 0, 0, 0, row - 1, col - 1);
            return min == Integer.MAX_VALUE ? -1 : min;
        }

        int min = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();

        void bfs(int[][] grid, boolean[][] visited, List<Integer> midlist, int curx, int cury, int sx, int sy, int ex, int ey) {
            System.out.println("bfs");
            if (curx == ex && cury == ey) {
                result.add(midlist);
                if (midlist.size() < min) {
                    min = midlist.size();
                }
                System.out.println("success");
                return;
            }
            for (int[] d : direction) {
                int nx = curx + d[0];
                int ny = cury + d[1];
                if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length || visited[nx][ny] || grid[nx][ny] == 1) {
                    continue;
                }
                visited[curx][cury] = true;
                midlist.add(grid[curx][cury]);
                bfs(grid, visited, midlist, nx, ny, sx, sy, ex, ey);
                visited[curx][cury] = false;
                midlist.remove(midlist.size() - 1);
            }

        }

        int[][] direction = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {0, -1}, {1, 0}, {1, -1}, {1, 1}};
    }

    static class Solution4 {
        public int shortestPathBinaryMatrix(int[][] grid) {
            if(grid == null || grid.length == 0){
                return 0;
            }
            if(grid[0][0] == 1){
                return -1;
            }
            int[][] dir = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{0, 0});
            int level = 0;
            while(!q.isEmpty()){
                int size = q.size();
                level++;
                while(size-- > 0){
                    int[] top = q.poll();
                    if(grid[top[0]][top[1]] == 1){
                        continue;
                    }
                    if(top[0] == grid.length - 1 && top[1] == grid[0].length - 1){
                        return level;
                    }
                    grid[top[0]][top[1]] = 1;
                    for(int i = 0; i < 8; i++){
                        int x = top[0] + dir[i][0];
                        int y = top[1] + dir[i][1];
                        if(x < 0 || x > grid.length - 1
                                || y < 0 || y> grid[0].length - 1){
                            continue;
                        }
                        q.offer(new int[]{x, y});
                    }
                }
            }
            return -1;
        }


    }
}
