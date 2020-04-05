package com.huluhaziqi.algorithms.algorithms.dynamic_programming;

import java.util.*;

public class WordBreak {

    /**
     * leetcode 139
     * 139. Word Break
     * Medium
     *
     * 3610
     *
     * 193
     *
     * Add to List
     *
     * Share
     * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
     *
     * Note:
     *
     * The same word in the dictionary may be reused multiple times in the segmentation.
     * You may assume the dictionary does not contain duplicate words.
     * Example 1:
     *
     * Input: s = "leetcode", wordDict = ["leet", "code"]
     * Output: true
     * Explanation: Return true because "leetcode" can be segmented as "leet code".
     * Example 2:
     *
     * Input: s = "applepenapple", wordDict = ["apple", "pen"]
     * Output: true
     * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
     *              Note that you are allowed to reuse a dictionary word.
     * Example 3:
     *
     * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * Output: false
     * Accepted
     * 485,013
     * Submissions
     * 1,256,641
     "catsandog"
     ["cats","dog","sand","and","cat"]
     */
    public static void main(String[] args) {

        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats","dog","sand","and","cat");
        boolean result = new WordBreak().wordBreak2(s,wordDict);
        System.out.println(result);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        Set<List<String>> result = getAll(wordDict, wordDict.size() - 1);
        for (List<String> r : result) {
            StringBuilder sb = new StringBuilder();
            for (String sub : r) {
                sb.append(sub);
            }
            if (sb.length() != 0 && s.contains(sb.toString())) {
                return true;
            }
        }
        return false;
    }

    public Set<List<String>> getAll(List<String> wordDict, int x) {
        Set<List<String>> result = new HashSet<>();
        if (x < 0) {
            return null;
        }
        if (x == 0) {
            List<String> tem = new LinkedList<>();
            tem.add(wordDict.get(0));
            result.add(tem);
            return result;
        }
        Set<List<String>> sub = getAll(wordDict, x - 1);
        sub.forEach(o -> {
            for (int i = 0; i <= x; i++) {
                List<String> tem = new LinkedList<>(o);
                tem.add(i, wordDict.get(x));
                if(!result.contains(tem)) {
                    result.add(tem);
                }
            }
        });
        return result;
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (String word : wordDict) {
                int size = word.length();
                if (size <= i && word.equals(s.substring(i - size,i))) {
                    dp[i] = dp[i] || dp[i - size];
                }
            }
        }
        return dp[len];
    }

    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0){
                return false;
            }
            int len = s.length();
            boolean[] dp = new boolean[len + 1];
            dp[0] = true;
            for(int j = 1; j<= len; j++){
                for(String word : wordDict){
                    int wordSize = word.length();
                    if(j >= wordSize && s.substring(j - wordSize,j).equals(word)){
                        dp[j] = dp[j] || dp[j - wordSize];
                    }
                }
            }
            return dp[len];
        }
    }
}
