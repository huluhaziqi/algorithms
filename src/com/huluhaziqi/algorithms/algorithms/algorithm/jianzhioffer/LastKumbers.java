package com.huluhaziqi.algorithms.algorithms.algorithm.jianzhioffer;

import java.util.ArrayList;

public class LastKumbers {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(input == null || input.length == 0 || input.length < k){
            return result;
        }
        for(int i = 0; i < input.length; i++){
            int tem = input[i];
            int j = 0;
            if(i < k){
                j = i - 1;
            }else{
                j = k - 1;
            }
            for(; j >= 0 && input[j] >= tem; j--){
                input[j + 1] = input[j];
            }
            input[j + 1] = tem;
        }
        for(int i = 0; i < k && i < input.length; i++){
            result.add(input[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] input = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> result = solution2.GetLeastNumbers_Solution(input,4);
        for(int i = 0 ;i < result.size(); i++){
            System.out.println(result.get(i));
        }

    }
    public static class Solution2 {
        public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
            if(input == null || input.length < k){
                return new ArrayList<>();
            }
            ArrayList<Integer> result = new ArrayList<>();
            sortK(input,k);
            for(int i = input.length - 1; i >= input.length - k + 1; i--){
                result.add(input[i]);
            }
            return result;
        }
        public void sortK(int[] input,int k){
            buildMinHeap(input);
            for(int i = 0; i < k; i++){
                swap(input,0,input.length - i - 1);
                minHeapify(input,0,input.length - i - 1);
            }
        }
        public void buildMinHeap(int[] input){
            int len = input.length;
            for(int i = len / 2 ; i>=0; i--){
                minHeapify(input,i,len);
            }
        }
        public void minHeapify(int[] input,int start,int end){
            if(start >= end){
                return;
            }
            int parent = start;

            while(parent < end){
                int minIndex = parent;
                int lchild = 2 * parent + 1;
                int rchild = 2 * parent + 2;
                if(lchild < end && input[lchild] < input[minIndex]){
                    minIndex = lchild;
                }
                if(rchild < end && input[rchild] < input[minIndex]){
                    minIndex = rchild;
                }
                if(parent == minIndex){
                    break;
                }else{
                    swap(input,parent,minIndex);
                    parent = minIndex;
                }

            }
        }

        public void swap(int[] input,int i, int j){
            int tem = input[i];
            input[i] = input[j];
            input[j] = tem;
        }
    }
}
