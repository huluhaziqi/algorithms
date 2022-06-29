package com.huluhaziqi.algorithms.algorithms.set;

import java.util.HashSet;
import java.util.Set;

public class Leetcode128 {

    class Solution {
        public int longestConsecutive(int[] nums) {
            if(nums == null){
                return 0;
            }
            Set<Integer> set = new HashSet<>();
            for(int n : nums){
                set.add(n);
            }
            int longest = 0;
            for(int s : set){
                if(!set.contains(s - 1)){
                    int cur = s;
                    int len = 1;
                    while(set.contains(cur + 1)){
                        len++;
                        cur++;
                    }
                    longest = Math.max(longest, len);
                }
            }
            return longest;

        }
    }
}
