package com.huluhaziqi.algorithms.algorithms.greedy;

import java.util.Arrays;

public class LeetCode455 {

    /**
     * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie. Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
     * <p>
     * Note:
     * You may assume the greed factor is always positive.
     * You cannot assign more than one cookie to one child.
     * <p>
     * Example 1:
     * Input: [1,2,3], [1,1]
     * <p>
     * Output: 1
     * <p>
     * Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
     * And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
     * You need to output 1.
     * Example 2:
     * Input: [1,2], [1,2,3]
     * <p>
     * Output: 2
     * <p>
     * Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
     * You have 3 cookies and their sizes are big enough to gratify all of the children,
     * You need to output 2.
     */
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            if (g == null || g.length == 0 || s == null || s.length == 0) {
                return 0;
            }
            Arrays.sort(s);
            Arrays.sort(g);
            boolean[] isPeek = new boolean[s.length];
            Arrays.fill(isPeek, false);
            int count = 0;
            for (int i = 0; i < g.length; i++) {
                for (int j = 0; j < s.length; j++) {
                    if (isPeek[j] != true && s[j] >= g[i]) {
                        isPeek[j] = true;
                        count++;
                        break;
                    } else {
                        if (s[j] > g[i]) {
                            break;
                        }
                        continue;
                    }
                }
            }
            return count;
        }
    }

    /**
     * more fit, O(n)
     */
    class Solution2 {
        public int findContentChildren(int[] g, int[] s) {
            if (g == null || g.length == 0 || s == null || s.length == 0) {
                return 0;
            }
            Arrays.sort(s);
            Arrays.sort(g);
            int count = 0;
            int i = 0;
            int j = 0;
            while(i < g.length && j < s.length){
                if(g[i] <= s[j]) {
                    count++;
                    i++;
                }
                j++;
            }
            return count;
        }
    }

    class Solution3 {
        public int findContentChildren(int[] g, int[] s) {
            if(g == null || g.length == 0 || s == null || s.length == 0){
                return 0;
            }
            Arrays.sort(g);
            Arrays.sort(s);
            int i = 0;
            int j = 0;
            int count = 0;
            while(i < g.length && j < s.length){
                if(s[j]>= g[i]){
                    i++;
                    j++;
                    count++;
                } else {
                    j++;
                }
            }
            return count;
        }
    }
}
