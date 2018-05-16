package lin.java.test.algorithms.backTracing;

public class SudokuSolve {


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


}
