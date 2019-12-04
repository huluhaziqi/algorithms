package com.huluhaziqi.algorithms.algorithms.greedy;

public class LeetCode392 {

    class Solution {
        public boolean isSubsequence(String s, String t) {
            if (t == null || s == null || s.length() > t.length()) {
                return false;
            }
            if (s.length() == 0) {
                return true;
            }
            int index = -1;
            for (int i = 0; i < s.length(); i++) {
                index = t.indexOf(s.charAt(i), index + 1);
                if (index == -1) {
                    break;
                }
            }
            return index == -1 ? false : true;
        }
    }
}
