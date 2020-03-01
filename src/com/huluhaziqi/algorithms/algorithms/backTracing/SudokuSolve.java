package com.huluhaziqi.algorithms.algorithms.backTracing;

public class SudokuSolve {


    /**
     * 37. Sudoku Solver
     * Hard
     * <p>
     * 1390
     * <p>
     * 82
     * <p>
     * Add to List
     * <p>
     * Share
     * Write a program to solve a Sudoku puzzle by filling the empty cells.
     * <p>
     * A sudoku solution must satisfy all of the following rules:
     * <p>
     * Each of the digits 1-9 must occur exactly once in each row.
     * Each of the digits 1-9 must occur exactly once in each column.
     * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
     * Empty cells are indicated by the character '.'.
     * <p>
     * <p>
     * A sudoku puzzle...
     * <p>
     * <p>
     * ...and its solution numbers marked in red.
     * <p>
     * Note:
     * <p>
     * The given board contain only digits 1-9 and the character '.'.
     * You may assume that the given Sudoku puzzle will have a single unique solution.
     * The given board size is always 9x9.
     * Accepted
     * 165,128
     * Submissions
     * 403,184
     *
     * @param args
     */
    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        new SudokuSolve().solveSudoku(board);
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + ",");
            }
            System.out.println();
        }
    }

    public boolean solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int k = 1; k <= 9; k++) {
                        board[i][j] = (char) (k + '0');
                        if (isValid(board, i, j) && solveSudoku(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public void solveSudoku2(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                backtracking(board, i, j);
            }
        }
    }


    private boolean backtracking(char[][] board, int row, int col) {
        if (col >= 9) {
            return backtracking(board, row + 1, 0);
        }
        if (row == 9)
            return true;

        for (int num = 1; num <= 9; num++) {
            board[row][col] = (char) (num + '0');
            if (backtracking(board, row, col)) {
                return true;
            }
            board[row][col] = '.';
        }
        return false;
    }

    boolean isValid(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            if (i != x && board[i][y] == board[x][y]) {
                return false;
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            if (i != y && board[x][i] == board[x][y]) {
                return false;
            }
        }

        for (int i = 3 * (x / 3); i < 3 * (x / 3 + 1); i++) {
            for (int j = 3 * (y / 3); j < 3 * (y / 3 + 1); j++) {
                if (i != x && y != j && board[x][x] == board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    class Solution {
        private char[][] board;

        public void solveSudoku(char[][] board) {
            this.board = board;
            if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
                return;
            }
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    }
                    int c = board[i][j] - '0';
                    rowUsed[i][c] = true;
                    colUsed[j][c] = true;
                    cubeUsed[cubeNum(i, j)][c] = true;
                }
            }
            dfs(0, 0);
        }

        boolean dfs(int row, int col) {

            while (row < 9 && board[row][col] != '.') {
                row = col == 8 ? row + 1 : row;
                col = col == 8 ? 0 : col + 1;
            }
            if (row == 9) {
                return true;
            }
            for (int k = 1; k <= 9; k++) {

                if (rowUsed[row][k] || colUsed[col][k] || cubeUsed[cubeNum(row, col)][k]) {
                    continue;
                }
                rowUsed[row][k] = colUsed[col][k] = cubeUsed[cubeNum(row, col)][k] = true;
                char c = (char) (k + '0');
                board[row][col] = c;
                if (dfs(row, col)) {
                    return true;
                }
                board[row][col] = '.';
                rowUsed[row][k] = colUsed[col][k] = cubeUsed[cubeNum(row, col)][k] = false;
            }
            return false;


        }

        int cubeNum(int i, int j) {
            int x = i / 3;
            int y = j / 3;
            return x * 3 + y;
        }

        boolean rowUsed[][] = new boolean[9][10];
        boolean colUsed[][] = new boolean[9][10];
        boolean cubeUsed[][] = new boolean[9][10];

    }

}
