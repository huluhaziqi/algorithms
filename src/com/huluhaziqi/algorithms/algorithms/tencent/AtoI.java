package com.huluhaziqi.algorithms.algorithms.tencent;

public class AtoI {


    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "   -42";
        int result = solution.myAtoi(str);
        System.out.println(result);
    }

    static class Solution {
        public int myAtoi(String str) {
            if (str == null || str.length() == 0) {
                return 0;
            }
            str = str.trim();
            if (str.length() == 0) {
                return 0;
            }
            char c = str.charAt(0);
            if ((c >= '0' && c <= '9') || c == '-' || c == '+') {
                String[] string = str.split(" ");
                str = string[0];
            }
            boolean flag = false;
            long result = 0;
            int index = 1;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '-') {
                    flag = true;
                    continue;
                }
                result = result * 10 + (str.charAt(i) - '0');
                boolean tem = ((result > Integer.MAX_VALUE) && !flag) ;
                boolean tem2 = ((result > Integer.MAX_VALUE + 1) && flag);
                System.out.println("tem " + tem + "tem2 " +tem2);

                if (((result > Integer.MAX_VALUE) && !flag) || ((result > (long) (Integer.MAX_VALUE + 1)) && flag)) {
                    return (flag ? Integer.MIN_VALUE : Integer.MAX_VALUE);
                }
            }
            return (int) result * (flag ? -1 : 1);
        }
    }
}
