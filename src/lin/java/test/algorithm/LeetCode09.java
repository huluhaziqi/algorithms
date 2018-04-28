package lin.java.test.algorithm;

import java.util.Scanner;

public class LeetCode09 {
    public static void main(String[] args) {
        /**
         * Determine whether an integer is a palindrome. Do this without extra space.

         click to show spoilers.
         */
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            Integer integer = Integer.valueOf(s);
            boolean result = new Solution09().isPalindrome2(integer);
            System.out.println(result);
        }
    }
}

class Solution09 {
    public boolean isPalindrome(int x) {
        long result = 0;
        int xx = x;
        for(;xx !=0; xx = xx / 10){
            result = result * 10 + xx % 10;
        }
        if(result >Integer.MAX_VALUE || result < Integer.MIN_VALUE || (int)result != x){
            return false;
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        long reverse = 0;
        int tem = x;
        if(x < 0){
            return false;
        }
        for(;x != 0; x /= 10){
            reverse = reverse * 10 + x % 10;
        }
        if(reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE || (int)reverse != tem){
            return false;
        }
        return true;
    }
}
