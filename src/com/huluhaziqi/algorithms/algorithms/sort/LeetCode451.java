package com.huluhaziqi.algorithms.algorithms.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode451 {

    // 451. Sort Characters By Frequency (Medium)
    //
    //
    // Input:
    // "tree"
    //
    // Output:
    // "eert"
    //
    // Explanation:
    // 'e' appears twice while 'r' and 't' both appear once.
    // So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
    class Solution {
        public String frequencySort(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            Map<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                if (!map.containsKey(c)) {
                    map.put(c, 1);
                } else {
                    map.put(c, map.get(c) + 1);
                }
            }
            List<List<Character>> freq = new ArrayList<>();
            for (int i = 0; i <= s.length(); i++) {
                freq.add(new ArrayList<>());
            }
            for (Character c : map.keySet()) {
                int value = map.get(c);
                freq.get(value).add(c);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = freq.size() - 1; i >= 0; i--) {
                List<Character> sub = freq.get(i);
                for (Character c : sub) {
                    for (int k = 0; k < i; k++) {
                        sb.append(c);
                    }
                }
            }
            return sb.toString();
        }
    }
}
