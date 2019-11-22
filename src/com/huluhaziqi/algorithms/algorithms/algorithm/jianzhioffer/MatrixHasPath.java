package com.huluhaziqi.algorithms.algorithms.algorithm.jianzhioffer;

public class MatrixHasPath {

    public static void main(String[] args) {
        char[] matrix = "ABCESFCSADEE".toCharArray();
        int rows = 3;
        int cols = 4;
        char[] str = "ABCB".toCharArray();
        Solution solution = new Solution();
        boolean result = solution.hasPath(matrix,rows,cols,str);
        System.out.println(result);
    }

    public static class Solution {
        public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
            if (matrix == null || matrix.length == 0) {
                return false;
            }
            char[][] array = buildMatrix(matrix, rows, cols);
            boolean[][] visited = new boolean[rows][cols];

            for(int i = 0; i < rows;i++){
                for(int j = 0; j < cols;j++){
                    if(dfs(array,new StringBuilder(),visited,j,i,str)){
                        return true;
                    }
                }
            }
            return false;
        }

        int[][] direct = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public boolean dfs(char[][] matrix, StringBuilder sb, boolean[][] visited, int col, int row, char[] str) {
            if (sb.length() == str.length) {
                    return true;
            }
            if (col < 0 || col >= matrix[0].length || row < 0 || row >= matrix.length ||
                    sb.length() > str.length || visited[row][col] || matrix[row][col] != str[sb.length()]) {
                return false;
            }
            boolean result = false;
            for (int[] d : direct) {

                int nextCol = col + d[1];
                int nextRow = row + d[0];
                visited[row][col] = true;
                sb.append(matrix[row][col]);
                if (dfs(matrix, sb, visited, nextCol, nextRow, str))
                    return true;
                sb.deleteCharAt(sb.length() - 1);
                visited[row][col] = false;
            }
            return result;
        }

        public char[][] buildMatrix(char[] array, int rows, int cols) {
            char[][] matrix = new char[rows][cols];
            int k = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = array[k++];
                }
            }
            return matrix;
        }
    }
    public class Solution2 {
        public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
            if (rows == 0 || cols == 0)
                return false;
            boolean[][] visited = new boolean[rows][cols];
            char[][] array = buildMatrix(matrix, rows, cols);
            for(int i = 0; i < rows;i++){
                for(int j = 0; j < cols;j++){
                    if(dfs(array,0,visited,j,i,str)){
                        return true;
                    }
                }
            }
            return false;
        }

        int[][] direct = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public boolean dfs(char[][] matrix, int len, boolean[][] visited, int col, int row, char[] str) {
            if (len == str.length) {
                return true;
            }
            if (col < 0 || col >= matrix[0].length || row < 0 || row >= matrix.length || visited[row][col] || matrix[row][col] != str[len]) {
                return false;
            }
            boolean result = false;
            for (int[] d : direct) {

                int nextCol = col + d[1];
                int nextRow = row + d[0];
                visited[row][col] = true;
                if (dfs(matrix, len + 1, visited, nextCol, nextRow, str))
                    return true;
                visited[row][col] = false;
            }
            return result;
        }

        public char[][] buildMatrix(char[] array, int rows, int cols) {
            char[][] matrix = new char[rows][cols];
            int k = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = array[k++];
                }
            }
            return matrix;
        }
    }

}
