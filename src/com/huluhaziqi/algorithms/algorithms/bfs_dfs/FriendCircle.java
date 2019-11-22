package com.huluhaziqi.algorithms.algorithms.bfs_dfs;

public class FriendCircle {

    public static void main(String[] args) {
        int[][] grid = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
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
        for(int i = 0; i < len ;i++){
            if(visited[i] == false) {
                dfs(M, i, visited);
                count++;
            }
        }
        return count;

    }

    public void dfs(int grid[][] ,int k ,boolean[] visited){
        for(int i = 0 ; i < grid.length;i++){
            if(grid[k][i] == 1 && visited[i] == false){
                visited[i] = true;
                dfs(grid,i,visited);
            }
        }
    }


}
