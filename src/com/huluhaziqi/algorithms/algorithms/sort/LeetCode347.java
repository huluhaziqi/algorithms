package com.huluhaziqi.algorithms.algorithms.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode347 {

    // Given a non-empty array of integers, return the k most frequent elements.
    //
    //Example 1:
    //
    //Input: nums = [1,1,1,2,2,3], k = 2
    //Output: [1,2]
    //Example 2:
    //
    //Input: nums = [1], k = 1
    //Output: [1]
    class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            if(nums == null || nums.length ==0){
                return new ArrayList<>();
            }
            Map<Integer,Integer> map = new HashMap<>();
            for(int i :nums){
                if(map.containsKey(i)){
                    map.put(i, map.get(i) +1);
                } else {
                    map.put(i, 1);
                }
            }
            List<Integer>[] fre = new ArrayList[nums.length +1];
            for(int i : map.keySet()) {
                int value = map.get(i);
                if(fre[value] == null){
                    fre[value] = new ArrayList<>();
                }
                fre[value].add(i);
            }
            List<Integer> result = new ArrayList<>();
            for(int i = fre.length - 1; i>= 0; i--){
                if(fre[i] == null) {
                    continue;
                }
                if(fre[i].size() <= k - result.size()){
                    result.addAll(fre[i]);
                } else {
                    result.addAll(fre[i].subList(0, k - result.size()));
                }
            }
            return result;
        }
    }

    class Solution2 {
        public List<Integer> topKFrequent(int[] nums, int k) {
            if(nums == null || nums.length == 0){
                return new ArrayList<>();
            }
            Map<Integer,Integer> map = new HashMap<>();
            for(int i : nums){
                if(map.containsKey(i)){
                    map.put(i, map.get(i) +1);
                } else {
                    map.put(i, 1);
                }
            }
            List<List<Integer>> fre = new ArrayList<>();
            for (int i = 0; i <= nums.length; i++) {
                fre.add(new ArrayList<>());
            }
            for(int i :map.keySet()){
                int value = map.get(i);
                if(fre.get(value) == null) {
                    fre.set(value, new ArrayList<>());
                }
                fre.get(value).add(i);
            }
            List<Integer> result = new ArrayList<>();
            int index = 0;
            for(int i = fre.size() - 1; i >= 0; i--){
                if(fre.get(i) != null){
                    for(int j = 0; j < fre.get(i).size(); j++){
                        if(result.size() < k) {
                            result.add(fre.get(i).get(j));
                        }else {
                            return result;
                        }
                    }
                }
            }
            return result;
        }
    }
}
