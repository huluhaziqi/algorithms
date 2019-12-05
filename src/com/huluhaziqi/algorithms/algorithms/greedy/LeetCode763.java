package com.huluhaziqi.algorithms.algorithms.greedy;

import java.util.ArrayList;
import java.util.List;

public class LeetCode763 {

    /**
     * 763. Partition Labels
     * Medium
     * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
     *
     * Example 1:
     * Input: S = "ababcbacadefegdehijhklij"
     * Output: [9,7,8]
     * Explanation:
     * The partition is "ababcbaca", "defegde", "hijhklij".
     * This is a partition so that each letter appears in at most one part.
     * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
     * Note:
     *
     * S will have length in range [1, 500].
     * S will consist of lowercase letters ('a' to 'z') only.
     */
    static class Solution {
        public List<Integer> partitionLabels(String s) {
            if (s == null || s.length() == 0) {
                return new ArrayList<>();
            }
            List<Integer> result = new ArrayList<>();
            int[] lastIndex = new int[26];
            for (int i = 0; i < s.length(); i++) {
                lastIndex[toInt(s.charAt(i))] = i;
            }
            int i = 0;
            while (i < s.length()) {
                int end = i;
                int first;
                for (first = i; first < s.length() && first <= end; first++) {
                    int tem = lastIndex[toInt(s.charAt(first))];
                    if (tem > end) {
                        end = tem;
                    }
                }
                result.add(end - i + 1);
                i = end + 1 ;
            }
            return result;
        }

        public int toInt(char a) {
            return a - 'a';
        }
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        Solution solution = new Solution();
        List<Integer> result = solution.partitionLabels(s);
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}
