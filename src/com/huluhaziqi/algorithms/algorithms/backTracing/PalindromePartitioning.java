package com.huluhaziqi.algorithms.algorithms.backTracing;

import java.util.*;

public class PalindromePartitioning {

    /**
     * 131. Palindrome Partitioning
     * Medium
     * <p>
     * 1414
     * <p>
     * 55
     * <p>
     * Add to List
     * <p>
     * Share
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     * <p>
     * Return all possible palindrome partitioning of s.
     * <p>
     * Example:
     * <p>
     * Input: "aab"
     * Output:
     * [
     * ["aa","b"],
     * ["a","a","b"]
     * ]
     * Accepted
     * 202,913
     * Submissions
     * 453,069
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> result = new PalindromePartitioning().partition(s);
        result.forEach(o -> {
            o.forEach(p -> System.out.print(p + " "));
            System.out.print("     ");
        });
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backTracing(s, 0, new ArrayList<>(), result);
        return result;
    }

    void backTracing(String s, int start, List<String> value, List<List<String>> ret) {
        if (start > s.length()) {
            return;
        }
        if (start == s.length()) {
            ret.add(new ArrayList<>(value));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String tem = s.substring(start, i + 1);
            if (!checkPal(s, start, i)) {
                continue;
            }
            value.add(tem);
            backTracing(s, i + 1, value, ret);
            value.remove(value.size() - 1);
        }
    }

    boolean checkPal(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    class Solution {
        public List<List<String>> partition(String s) {
            if (s == null || s.length() == 0) {
                return new ArrayList<>();
            }
            List<List<String>> result = new ArrayList<>();
            dfs(s, s.length(), 0, new LinkedList<>(), result);
            return result;
        }

        void dfs(String s, int n, int k, List<String> list, List<List<String>> result) {
            if (k == n) {
                result.add(new LinkedList<>(list));
                return;
            }
            for (int i = k; i < n; i++) {
                if (!palind(s, k, i)) {
                    continue;
                }
                String tem = s.substring(k, i + 1);
                list.add(tem);
                dfs(s, n, i + 1, list, result);
                list.remove(list.size() - 1);
            }
        }

        boolean palind(String s, int start, int end) {
            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
    }

}
