package com.huluhaziqi.algorithms.algorithms.backTracing;


import java.util.*;

public class CombinationSum4 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 2;
        int result = new CombinationSum4().combinationSum4(nums,target);
        System.out.println(result);
}
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        dfs(nums,new ArrayList<>(),target);
        return v;
    }
    int v = 0;
    void dfs(int[] nums, List<Integer> value, int target){
        if(sum(value) == target){
            v++;
            return;
        }
        if(sum(value) > target){
            return;
        }
        for(int i = 0; i < nums.length; i++){
            value.add(nums[i]);
            dfs(nums,value,target);
            value.remove(value.size() - 1);
        }
    }

    int sum(List<Integer> value){
        int sum = 0;
        for(int v :value){
            sum += v;
        }
        return sum;
    }
}
