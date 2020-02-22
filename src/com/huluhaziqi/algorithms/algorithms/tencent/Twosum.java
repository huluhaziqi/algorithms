package com.huluhaziqi.algorithms.algorithms.tencent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Twosum {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }
            Map<Integer, Integer> map = new HashMap<>();
            int len = nums.length;
            for (int i = 0; i < len; i++ ) {
                if(map.containsKey(target - nums[i])){
                    return new int[]{map.get(target - nums[i]), i };
                } else {
                    map.put(nums[i], i);
                }
            }
            return new int[0];
        }
    }
}
