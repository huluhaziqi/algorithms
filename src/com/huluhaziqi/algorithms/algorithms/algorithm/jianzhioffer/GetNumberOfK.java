package com.huluhaziqi.algorithms.algorithms.algorithm.jianzhioffer;

public class GetNumberOfK {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {1,2,3,3,3,3,4,5};
        int k = 6;
        int result = solution.GetNumberOfK(array,k);
        System.out.println(result);
    }

    public static class Solution {
        public int GetNumberOfK(int [] array , int k) {
            if(array == null || array.length == 0){
                return 0;
            }
            int i = 0;
            int result = 0;
            int len = array.length;
            int l = 0;
            int r = len - 1;
            int index = 0;
            int count = 0;
            while(l <= r){
                int mid = (l + r ) / 2;
                if(array[mid] >= k){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
            if(l < 0 || l > array.length - 1 || array[l] != k){
                return 0;
            }else{
                for(int h = l; h < len && array[l] == array[h]; h++){
                    count++;
                }
            }
            return count;
        }
    }
}
