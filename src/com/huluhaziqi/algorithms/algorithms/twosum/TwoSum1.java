package com.huluhaziqi.algorithms.algorithms.twosum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if(nums == null || nums.length < 2){
            return new int[0];
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length;i++){
            if(map.containsKey(target - nums[i])){
                nums[0] = map.get(target - nums[i]);
                nums[1] = map.get(nums[i]);
                break;
            }
            map.put(nums[i],i);
        }
        return nums;
    }
}
