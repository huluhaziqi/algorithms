package com.huluhaziqi.algorithms.algorithms.twosum;

public class LeetCode680 {

    class Solution {
        public boolean validPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return false;
            }
            int i = 0;
            int j = s.length() - 1;
            char[] chars = s.toCharArray();
            while (i < j) {
                if (chars[i] != chars[j]) {
                    return judge(chars, i + 1, j) || judge(chars, i, j - 1);
                }
                i++;
                j--;
            }
            return true;
        }

        public boolean judge(char[] chars, int i, int j) {
            if (i > j) {
                return false;
            }
            if (chars == null || chars.length == 0) {
                return false;
            }
            while (i <= j) {
                if (chars[i] != chars[j]) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }

    class Solution2 {
        public boolean validPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return false;
            }
            int l = 0;
            int h = s.length() - 1;
            while (l < h) {
                if (s.charAt(l) != s.charAt(h)) {
                    return judge(s, l + 1, h) || judge(s, l, h - 1);
                }
                l++;
                h--;
            }

            return true;
        }

        boolean judge(String s, int i, int j) {
            int l = i;
            int h = j;
            while (l < h) {
                if (s.charAt(l) != s.charAt(h)) {
                    return false;
                }
                l++;
                h--;
            }
            return true;
        }
    }
}
