package lin.java.test.algorithms.algorithm.jianzhioffer;

import java.util.Arrays;

public class HasPath {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "ABCESFCSADEE";
        char[] matrix = str.toCharArray();
        solution.hasPath(matrix,3,4,"ABCCED".toCharArray());
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
}
