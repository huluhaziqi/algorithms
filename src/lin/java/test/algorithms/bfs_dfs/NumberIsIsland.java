package lin.java.test.algorithms.bfs_dfs;

public class NumberIsIsland {

    public static void main(String[] args) {
        int[][] m = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        int result = new NumberIsIsland().findCircleNum(m);
        System.out.println(result);
    }

    int[][] direction = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result += dfs(grid, i, j) != 0 ? 1 : 0;
            }
        }
        return result;
    }

    int dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return 0;
        }
        grid[i][j] = '0';
        int count = 1;
        for (int[] d : direction) {
            count += dfs(grid, i + d[0], j + d[1]);
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
}
