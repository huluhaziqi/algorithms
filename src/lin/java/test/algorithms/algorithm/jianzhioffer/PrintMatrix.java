package lin.java.test.algorithms.algorithm.jianzhioffer;

import java.util.ArrayList;

public class PrintMatrix {

    public static void main(String[] args) {
        int [][] matrix = {{1},{2},{3},{4},{5}};
        printMatrix(matrix);
    }

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> result =  new ArrayList<Integer>();
        int row = matrix.length;
        int col = matrix[0].length;
        int mid = ((row > col ? row : col) - 1) / 2 + 1;
        for(int i = 0; i < mid; i++ ){
            for(int k = i; k < col - i;k++){
                result.add(matrix[i][k]);
            }
            for(int k = i + 1; k < row - i;k++){
                result.add(matrix[k][col - i - 1]);
            }
            for(int k = col - i - 2; k >= i && ((row) - 1 - i)  != i;k--){
                result.add(matrix[row - i - 1][k]);
            }
            for(int k = row - i - 2; k > i && ((col) - 1 - i )  != i;k--){
                result.add(matrix[k][i]);
            }
        }
        return result;

    }
}
