package com.huluhaziqi.algorithms.algorithms.twosum;

public class LeetCode345 {

    class Solution {
        public String reverseVowels(String s) {
            if(s == null || s.length() == 0){
                return "";
            }
            char[] chars = s.toCharArray();
            int i = 0;
            int j = chars.length - 1;
            while(i < j && i < s.length() && j >=0){
                while(i < s.length() && !isR(chars[i])){
                    i++;
                }
                while(j >= 0 && !isR(chars[j])){
                    j--;
                }
                if(i <s.length() && j >= 0 &&  i <= j) {
                    char tmp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = tmp;
                    i++;
                    j--;
                }
            }
            return new String(chars);
        }

        public boolean isR(char b){
            char a = Character.toLowerCase(b);
            if(a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u'){
                return true;
            }
            return false;
        }
    }
}
