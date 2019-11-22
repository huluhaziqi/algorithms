package com.huluhaziqi.algorithms.algorithms.dynamic_programming;

public class WordSearch {
    public static void main(String[] args) {
         char[][] board = {{'a','b'},{'c','d'}};
         boolean result = exist(board,"abcd");
        System.out.println(result);
    }

    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) {
            return false;
        }
        int[] dp = new int[256];
        boolean tem = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dp[board[i][j] - 'A']++;
            }
        }
        char[] words = word.toCharArray();
        for (int i = 0; i < words.length; i++) {
            if (--dp[(words[i] - 'A')] < 0) {
                return false;
            }
        }
        return true;
    }
}
