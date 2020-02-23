package com.huluhaziqi.algorithms.algorithms.bfs_dfs;

public class SurroundedRegions {

    int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * LeetCode130. Surrounded Regions
     * Medium
     * <p>
     * 1179
     * <p>
     * 539
     * <p>
     * Add to List
     * <p>
     * Share
     * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
     * <p>
     * A region is captured by flipping all 'O's into 'X's in that surrounded region.
     * <p>
     * Example:
     * <p>
     * X X X X
     * X O O X
     * X X O X
     * X O X X
     * After running your function, the board should be:
     * <p>
     * X X X X
     * X X X X
     * X X X X
     * X O X X
     * Explanation:
     * <p>
     * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
     * <p>
     * Accepted
     *
     * @param args
     */
    public static void main(String[] args) {
        char[][] board = {{'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'}, {
                'O', 'X', 'O', 'X', 'O', 'X'}
        };
        new SurroundedRegions().solve(board);
        for (char[] c : board) {
            for (char t : c) {
                System.out.print(t + " ");
            }
            System.out.println();
        }
    }

    public void solve2(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < col; i++) {
            dfs2(board, 0, i);
            dfs2(board, row - 1, i);
        }
        for (int i = 0; i < row; i++) {
            dfs2(board, i, 0);
            dfs2(board, i, col - 1);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs2(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'T';
        for (int[] d : direct) {
            dfs2(board, i + d[0], j + d[1]);
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        for (int i = 0; i < board[0].length; i++) {
            dfs(board, 0, i);
            dfs(board, board.length - 1, i);
        }
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        if (board == null || board.length == 0 || i < 0 || i >= board.length ||
                j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'T';
        for (int[] d : direct) {
            dfs(board, i + d[0], j + d[1]);
        }
    }


    class Solution {
        public void solve(char[][] board) {
            if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
                return;
            }
            int row = board.length;
            int col = board[0].length;
            for (int i = 0; i < col; i++) {
                dfs(board, 0, i);
                dfs(board, row - 1, i);
            }
            for (int i = 1; i < row - 1; i++) {
                dfs(board, i, 0);
                dfs(board, i, col - 1);
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'T') board[i][j] = 'O';
                    else board[i][j] = 'X';
                }
            }
        }

        int[][] dire = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        void dfs(char[][] board, int i, int j) {
            if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != 'O') {
                return;
            }
            board[i][j] = 'T';
            for (int[] d : dire) {
                dfs(board, i + d[0], j + d[1]);
            }
        }
    }

}
