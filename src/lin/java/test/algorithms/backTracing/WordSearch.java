package lin.java.test.algorithms.backTracing;

public class WordSearch {


    public static void main(String[] args) {
        char[][] board = {
                {'B'}

        };
        String word = "B";
        boolean result = new WordSearch().exist(board, word);
        System.out.println(result);
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        int row = board.length;
        int col = board[0].length;

        boolean result = false;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (dfs(board, i, j, 0, word, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    int[][] direct = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public boolean dfs(char[][] board, int i, int j, int start, String word, boolean[][] visited) {
        if (start == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] == true || word.charAt(start) != board[i][j]) {
            return false;
        }
        visited[i][j] = true;
        for (int[] d : direct) {
            int temI = i + d[0];
            int temJ = j + d[1];
            if(dfs(board, temI, temJ, start + 1, word, visited)){
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}
