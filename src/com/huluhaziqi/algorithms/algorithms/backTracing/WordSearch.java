package com.huluhaziqi.algorithms.algorithms.backTracing;

public class WordSearch {


    public static void main(String[] args) {
//        char[][] board = {
//////                {'B'}
//////
//////        };
//////        String word = "B";
//////        boolean result = new WordSearch().exist(board, word);
//////        System.out.println(result);
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        boolean result = new Solution().exist(board, word);
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
            if (dfs(board, temI, temJ, start + 1, word, visited)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }

    static class Solution {
        public boolean exist(char[][] board, String word) {
            if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
                return false;
            }
            if (word == null || word.length() == 0) {
                return true;
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (dfs(board, i, j, word, new StringBuilder(), 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        boolean dfs(char[][] board, int i, int j, String word, StringBuilder sb, int index) {
            if (index == word.length()) {
                return true;
            }
            if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != word.charAt(index)) {
                return false;
            }
            index++;
            for (int[] d : directions) {
                int ni = i + d[0];
                int nj = j + d[1];
                sb.append(board[ni][nj]);
                dfs(board, ni, nj, word, sb, index);
                sb.deleteCharAt(sb.length() - 1);
            }
            return false;
        }
    }
}
