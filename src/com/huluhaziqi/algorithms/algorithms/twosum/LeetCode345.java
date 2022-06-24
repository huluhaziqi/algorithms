package com.huluhaziqi.algorithms.algorithms.twosum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode345 {


    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.reverseVowels("a.b,.");
    }

    class Solution {
        public String reverseVowels(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            char[] chars = s.toCharArray();
            int i = 0;
            int j = chars.length - 1;
            while (i < j && i < s.length() && j >= 0) {
                while (i < s.length() && !isR(chars[i])) {
                    i++;
                }
                while (j >= 0 && !isR(chars[j])) {
                    j--;
                }
                if (i < s.length() && j >= 0 && i <= j) {
                    char tmp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = tmp;
                    i++;
                    j--;
                }
            }
            return new String(chars);
        }

        public boolean isR(char b) {
            char a = Character.toLowerCase(b);
            if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') {
                return true;
            }
            return false;
        }
    }

    static class Solution2 {
        public String reverseVowels(String s) {
            if (s == null || s.length() <= 1) {
                return s;
            }
            int l = 0;
            int h = s.length() - 1;
            char[] chars = s.toCharArray();
            while (l < h) {
                while (!isVowels(s.charAt(l))) {
                    l++;
                }
                while (!isVowels(s.charAt(h))) {
                    h--;
                }
                if (l <= h) {
                    char tem = chars[l];
                    chars[l] = chars[h];
                    chars[h] = tem;
                    l++;
                    h--;
                }

            }
            return String.valueOf(chars);
        }


        boolean isVowels(char c) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                    || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                return true;
            }
            return false;
        }
    }

    class Solution3 {
        public String reverseVowels(String s) {
            if(s == null){
                return null;
            }
            Set<Character> set = new HashSet(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
            char[] str = s.toCharArray();
            int i = 0;
            int j = str.length - 1;
            while(i < j){
                if(!set.contains(str[i])){
                    i++;
                }
                if(!set.contains(str[i])){
                    j--;
                }
                if(set.contains(str[i]) && set.contains(str[j])){
                    Character tmp = str[i];
                    str[i] = str[j];
                    str[j] = tmp;
                    i++;
                    j--;
                }
            }
            return Arrays.toString(str);
        }
    }
}
