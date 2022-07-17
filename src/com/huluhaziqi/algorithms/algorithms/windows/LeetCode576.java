package com.huluhaziqi.algorithms.algorithms.windows;

import java.util.HashMap;
import java.util.Map;

public class LeetCode576 {
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1 == null || s2 == null) {
                return false;
            }
            Map<Character, Integer> hs1 = new HashMap<>();
            Map<Character, Integer> hs2 = new HashMap<>();
            for (char c : s1.toCharArray()) {
                hs1.put(c, hs1.getOrDefault(c, 0) + 1);
            }
            int right = 0;
            int left = 0;
            int cnt = 0;
            while (right < s2.length()) {
                char c = s2.charAt(right);
                hs2.put(c, hs2.getOrDefault(c, 0) + 1);
                if (hs1.containsKey(c) && hs2.get(c) <= hs1.get(c)) {
                    cnt++;
                }

                while (left < right && (!hs1.containsKey(s2.charAt(left)) || hs2.get(s2.charAt(left)) > hs1.get(s2.charAt(left)))) {
                    hs2.put(s2.charAt(left), hs2.get(s2.charAt(left)) - 1);
                    left++;
                }
                if (cnt == s1.length() && right - left + 1 == s1.length()) {
                    return true;
                }
                right++;
            }
            return false;
        }
    }
}
