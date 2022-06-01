package com.huluhaziqi.algorithms.algorithms.backTracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode51 {

    public static void main(String[] args) {
        int n = 4;
        Solution solution = new Solution();
        solution.solveNQueens(n);
    }
    static class Solution {
        public List<List<String>> solveNQueens(int n) {
            if(n<= 0){
                return qs;
            }
            d45 = new boolean[2* n - 1];
            d135 = new boolean[2 * n - 1];
            d =new boolean[n];
            q  = new char[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(q[i],'.');
            }
            this.n = n;
            qs = new ArrayList<>();
            dfs(0);
            return qs;
        }
        boolean[] d45;
        boolean[] d135;
        boolean[] d;
        List<List<String>> qs;
        char[][] q;
        int n ;
        void dfs(int row){
            System.out.println("n = " + n);

            if(row == n){
                List<String> list = new ArrayList<>();
                for(char[] c : q){
                    list.add(new String(c));
                }
                System.out.println("list = " + list);
                qs.add(list);
                return;
            }
            for(int i = 0; i < n; i++){
                int d45_i = row + i;
                int d135_i = n - 1 + i - row;
                if(d[i] || d45[d45_i] || d135[d135_i]){
                    continue;
                }
                d[i] = d45[d45_i] = d135[d135_i] = true;
                q[row][i] = 'Q';
                dfs(row + 1);
                q[row][i] = '.';
                d[i] = d45[d45_i] = d135[d135_i] = false;

            }
        }
    }
}
