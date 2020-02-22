package com.huluhaziqi.algorithms.algorithms.tencent;

public class AtoI {


    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "42";
        int result = solution.myAtoi(str);
        System.out.println(result);
    }

    static class Solution {
        public int myAtoi(String str) {
            if (str == null || str.trim().length() == 0) {
                return 0;
            }
            str = str.trim();
            int tag = 1;
            long result = 0;
            int temp = 1;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c >= '0' && c <= '9') {
                    int tem = c - '0';
                    result = result * 10 + tem;
                    if (tag == 1 && result >= Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                    if (tag == -1 && result > Integer.MAX_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                } else if ((c == '-' || c == '+') && i == 0) {
                    tag = (c == '-') ? -1 : 1;
                } else {
                    break;
                }
            }
            return (int) (result * tag);
        }

    }

    class Solution2 {
        public int myAtoi(String str) {
            if (str == null || str.trim().length() == 0) {
                return 0;
            }
            int len = str.length();
            int tag = 1;
            long result = 0;
            int start = 0;
            while (start < len) {
                if (str.charAt(start) == ' ') {
                    start++;
                    continue;
                } else {
                    break;
                }
            }
            if ((str.charAt(start) == '-' || str.charAt(start) == '+')) {
                tag = (str.charAt(start) == '-') ? -1 : 1;
                start++;
            }
            for (int i = start; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c >= '0' && c <= '9') {
                    int tem = c - '0';
                    result = result * 10 + tem;
                    if (tag == 1 && result >= Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                    if (tag == -1 && result > Integer.MAX_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    break;
                }
            }
            return (int) (result * tag);
        }

    }
}
