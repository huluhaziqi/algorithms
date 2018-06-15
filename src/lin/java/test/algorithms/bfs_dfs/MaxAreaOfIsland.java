package lin.java.test.algorithms.bfs_dfs;

public class MaxAreaOfIsland {

    int[][] direction2 = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        int reuslt = new MaxAreaOfIsland().maxAreaOfIsland(grid);
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
        for(int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                max = Math.max(dfs(grid,i,j,visited),max);
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
}
