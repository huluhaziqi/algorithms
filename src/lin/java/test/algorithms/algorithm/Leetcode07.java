package lin.java.test.algorithms.algorithm;

import java.util.Scanner;

public class Leetcode07 {
    /**
     * Given a 32-bit signed integer, reverse digits of an integer.
     * <p>
     * Example 1:
     * <p>
     * Input: 123
     * Output:  321
     * Example 2:
     * <p>
     * Input: -123
     * Output: -321
     * Example 3:
     * <p>
     * Input: 120
     * Output: 21
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            Integer integer = Integer.valueOf(s);
            boolean result = new Solution().isPalindrome(integer);
            System.out.println(result);
        }
    }

}

class Solution {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        long xx = x;
        String a = null;
        if (x < 0) {
            sb.append("-");
        }
        if (x == 0) {
            return 0;
        }
        xx = Math.abs(xx);
        int i = 1;
        int tag = 0;
        while (xx > 0) {
            long tem = xx / 10;
            long r = xx - tem * 10;
            sb.append(r);
            xx = tem;
        }
        System.out.println(sb.toString());
        long raw = Long.parseLong(sb.toString());
        if (raw > Integer.MAX_VALUE || raw < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) raw;
    }

    public int reverse2(int x) {
        long result = 0;
        int r = 0;
        int temp = 0;
        while (x != 0) {
            r = x % 10;
            result = result * 10 + r;
            x = x / 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }

    public int reverse3(int x) {
        long result = 0;
        for (; x != 0; x = x / 10) {
            result = result * 10 + x % 10;
        }
        return (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) ? 0 : (int)result;
    }

    public boolean isPalindrome(int x) {
        long temp = (long)x;
        long reverse = 0;
        if(x < 0){
            return false;
        }
        for(;x != 0; x /= 10){
            reverse += reverse * 10 + x % 10;
        }
        return (reverse == temp) ? true : false;
    }
}