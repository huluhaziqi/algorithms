package com.huluhaziqi.algorithms.algorithms.algorithm.jianzhioffer;

import java.util.ArrayList;

public class FindContinueSequence {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<ArrayList<Integer>> result = solution.FindContinuousSequence(3);
        System.out.println(result);
    }

    public static class Solution {
        public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            for (int i = 1; i < sum; i++) {
                int index = find(i, sum, sum);
                if (index != -1) {
                    ArrayList<Integer> tem = new ArrayList<>();
                    for (int j = i; j <= index; j++) {
                        tem.add(j);
                    }
                    result.add(tem);
                }
            }
            return result;
        }

        public int find(int start, int end, int target) {
            int l = start;
            int r = end;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (mid * mid + mid> 2 * target - start + start * start) {
                    r = mid - 1;
                } else if (mid * mid + mid < 2 * target - start + start * start) {
                    l = mid + 1;
                } else {
                    return mid;
                }
            }


            return -1;
        }
    }

    public static class Solution2 {
        public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            if(sum <= 2){
                return result;
            }
            int small = 1;
            int big = 2;
            while(small < (sum + 1) / 2){
                int tem = sum(small,big);
                if(tem > sum){
                    small++;
                }else if(tem < sum){
                    big++;
                }else{
                    ArrayList<Integer> list = new ArrayList<>();
                    for(int i = small; i <= big; i++){
                        list.add(i);
                    }
                    result.add(list);
                    small++;
                    big++;
                }
            }
            return result;
        }
        public int sum(int start,int end){
            return (end - start + 1) * (start + end) /2 ;
        }
    }

}
