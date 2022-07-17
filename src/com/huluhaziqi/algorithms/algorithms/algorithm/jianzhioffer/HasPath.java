package com.huluhaziqi.algorithms.algorithms.algorithm.jianzhioffer;

import java.util.Arrays;

public class HasPath {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String str = "ABCESFCSADEE";
        char[][] matrix = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        solution.hasPath(matrix,"ABCCED");
    }
    public static class Solution {
        public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
        {
            if(matrix == null || matrix.length == 0){
                return false;
            }
            char[][] tem = new char[rows][cols];
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    tem[i][j] = matrix[i * cols + j];
                }
            }
            boolean[][] visited = new boolean[rows][cols];
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    for(int m = 0; m < rows;m++)
                        Arrays.fill(visited[m],false);
                    dfs(tem,visited,i,j,0,str);
                    if(result){
                        return true;
                    }
                }
            }
            return false;
        }
        public boolean result = false;
        public void dfs(char[][] matrix,boolean[][] visited,int i, int j, int cur,char[] str){
            if(cur == str.length){
                result |= true;
                return;
            }
            if(i< 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j] ||
                    str[cur] != matrix[i][j]){
                return;
            }
            visited[i][j] = true;
            for(int k = 0; k < direct.length; k++){
                dfs(matrix,visited,i + direct[k][0],j + direct[k][1],cur + 1,str);
            }
            visited[i][j] = false;

        }
        private int[][] direct = {{0,1},{0,-1},{1,0},{-1,0}};


    }


    public static class Solution2{
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param matrix char字符型二维数组
         * @param word string字符串
         * @return bool布尔型
         */
        public boolean hasPath (char[][] matrix, String word) {
            // write code here
            if(matrix == null){
                return false;
            }
            int row = matrix.length;
            int col = matrix[0].length;
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(dfs(matrix,word,i,j,new boolean[row][col])){
                        return true;
                    }
                }
            }
            return false;
        }

        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        boolean dfs(char[][] matrix, String word, int x, int y, boolean[][] visited){
            if(word == ""){
                return true;
            }
            System.out.println("word = " + word);
            if(x < 0 || x > matrix.length - 1 || y < 0 || y > matrix[0].length - 1
                    || visited[x][y]|| (word.length()!= 0 && matrix[x][y] != word.charAt(0))){

                return false;
            }
            System.out.println("x = " + x + " y = " + y);
            System.out.println("word = " + word);

            visited[x][y] = true;
            for(int i = 0; i < 4; i++){
                int x1 = x + dir[i][0];
                int y1 = y + dir[i][1];
                System.out.println("x1 = " + x1 + " y1 = " + y1 + " word.substring(1)" + word.substring(1));

                if(dfs(matrix,word.substring(1),x1,y1,visited)){
                    return true;
                }
            }
            visited[x][y] = false;
            return false;
        }
    }
}
