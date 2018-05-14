package lin.java.test.algorithms.bfs_dfs;

public class FriendCircle {

    public static void main(String[] args) {
        int[][] grid = {{1,1,0},{1,1,0},{0,0,1}};
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
                count += dfs(grid, i, visited) != 0 ? 1 : 0;
            }
        }
        return count;
    }

    public int dfs(int[][] grid, int j, boolean[] visited) {
        int count = 1;
        for (int i = 0; i < n; i++) {
            if (grid[j][i] == 1 && visited[i] == false) {
                visited[i] = true;
                count += dfs(grid, i, visited);
            }
        }
        return count;
    }
}
