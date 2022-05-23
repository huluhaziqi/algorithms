package com.huluhaziqi.algorithms.algorithms.dynamic_programming;

import java.util.Stack;

public class LeetCode32 {

    class Solution {
        public int longestValidParentheses(String s) {
            if(s == null || s.length() == 0){
                return 0;
            }
            Stack<Character> st = new Stack<>();
            int len = s.length();
            int i = 0;
            while(i < len){

                if(!st.isEmpty() && st.peek().equals(')')){
                    st.pop();
                } else {
                    st.push(s.charAt(i));
                }
                i++;

            }
            return s.length() - st.size();
        }
    }
}
