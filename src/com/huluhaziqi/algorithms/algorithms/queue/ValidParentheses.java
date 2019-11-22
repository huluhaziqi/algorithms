package com.huluhaziqi.algorithms.algorithms.queue;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "(){}[]";
        boolean result = new ValidParentheses().isValid(s);
        System.out.println(result);
    }

    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        if (!stack.isEmpty())
            stack.clear();
        stack.push(s.charAt(0));
        int i = 1;
        while (i < s.length()) {
            Character top = 0;
            if (!stack.isEmpty()) {
                top = stack.peek();
            }
            Character cur = s.charAt(i);
            if ((cur == ')' && top == '(') || (cur == '}' && top == '{') || (cur == ']' && top == '[')) {
                stack.pop();
            } else {
                stack.push(cur);
            }
            i++;
        }
        return stack.isEmpty();
    }
}
