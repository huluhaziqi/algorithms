package lin.java.test.algorithms.bfs_dfs;

public class SurroundedRegions {

    int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        char[][] board = {{'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'}, {
                'O', 'X', 'O', 'X', 'O', 'X'}
        };
        new SurroundedRegions().solve(board);
        for(char[] c : board){
            for(char t : c){
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
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        for(int i = 0; i < board[0].length; i++){
            dfs(board,0,i);
            dfs(board,board.length - 1,i);
        }
        for(int i = 0; i < board.length ;i++){
            dfs(board,i,0);
            dfs(board,i,board[0].length - 1);
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length ;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                } else  if (board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board,int i, int j){
        if(board == null || board.length == 0 || i < 0 || i >= board.length||
                j < 0 || j >= board[0].length || board[i][j] != 'O'){
            return;
        }
        board[i][j] = 'T';
        for(int[] d : direct){
            dfs(board,i + d[0],j + d[1]);
        }
    }


}
