package com.huluhaziqi.algorithms.algorithms.tencent;

public class LongestCommonPrefix {

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            int i = 0;
            int len = strs[0].length();
            for (; i < len; i++) {
                if (!checkIsPrefix(strs, strs[0].substring(0, i + 1))) {
                    break;
                }
            }
            return strs[0].substring(0, i);

        }

        public boolean checkIsPrefix(String[] strs, String s) {
            if (s == null || s.length() == 0) {
                return false;
            }
            for (String str : strs) {
                if (str.startsWith(s)) {
                    continue;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
