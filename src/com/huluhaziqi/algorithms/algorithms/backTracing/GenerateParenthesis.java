package com.huluhaziqi.algorithms.algorithms.backTracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {

    class Solution {
        public List<String> generateParenthesis(int n) {
            if (n <= 0) {
                return new ArrayList<>();
            }
            List<String> result = new ArrayList<>();
            char[] c = new char[n * 2];
            boolean[] visited = new boolean[n * 2];
            for (int i = 0; i < n * 2; i++) {
                if (i < n) {
                    c[i] = '(';
                } else {
                    c[i] = ')';
                }
            }
            dfs(c, n, result, new StringBuilder(), visited);
            return result;

        }

        void dfs(char[] c, int n, List<String> result, StringBuilder sb, boolean[] visited) {
            if (sb.length() == 2 * n) {
                if (judge(sb.toString())) {
                    result.add(sb.toString());
                }
                return;
            }
            for (int i = 0; i < c.length; i++) {
                if (i > 0 && c[i] == c[i - 1] && !visited[i - 1]) {
                    continue;
                }
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                sb.append(c[i]);
                dfs(c, n, result, sb, visited);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }

        boolean judge(String s) {
            Stack<Character> stack = new Stack<>();
            int i = 1;
            stack.push(s.charAt(0));
            while (i < s.length()) {
                if (!stack.isEmpty()) {
                    char top = stack.peek();
                    if (top == '(' && s.charAt(i) == ')') {
                        stack.pop();
                    } else {
                        stack.push(s.charAt(i));
                    }
                } else {
                    stack.push(s.charAt(i));
                }
                i++;
            }
            return stack.isEmpty() ? true : false;
        }

    }
}
