package lin.java.test.algorithms.twosum;

import java.util.Arrays;
import java.util.List;

public class LeetCode524 {
//524. Longest Word in Dictionary through Deleting
//
//    Given a string and a string dictionary, find the longest string in the dictionary that
//    can be formed by deleting some characters of the given string. If there are more than one
//    possible results, return the longest word with the smallest lexicographical order.
//    If there is no possible result, return the empty string.
    static class Solution {
        public String findLongestWord(String s, List<String> d) {
            if(s == null || s.length() == 0){
                return "";
            }
            String result = "";
            for(String str : d){
                if(judge(s,str, s.length(), str.length())){
                    if(str.length() > result.length()){
                        result = str;
                    } else if(str.length() == result.length()){
                        result = str.compareTo(result) < 0 ? str :result;
                    }
                }
            }
            return result;
        }

        public boolean judge(String s, String word, int len1, int len2){
            if(len1 < len2){
                return false;
            }
            int i = 0;
            int j = 0;
            while(i < len1 && j < len2 ){
                if(s.charAt(i) == word.charAt(j)){
                    j++;
                }
                i++;
            }
            return j == len2;
        }
    }

    public static Solution getNew(){
        return new Solution();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findLongestWord("abpcplea",
                Arrays.asList("ale","apple","monkey","plea"));
    }
}
