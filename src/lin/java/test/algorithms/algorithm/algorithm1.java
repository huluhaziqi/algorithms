package lin.java.test.algorithms.algorithm;

import java.lang.*;

public class algorithm1 {
    public static void main(String[] args) {
        int result = hammingDistance(1, 4);
        System.out.print(result);
    }

    public static int hammingDistance(int x, int y) {
        if (x < 0 || x > Integer.MAX_VALUE || y < 0 || y > Integer.MAX_VALUE) {
            return -1;
        }
        int max = (x > y) ? x : y;
        int min = (x < y) ? x : y;
        String maxString = Integer.toBinaryString(max);
        String minString = Integer.toBinaryString(min);
        System.out.println(maxString);
        System.out.println(minString);
        int lenOfMin = minString.length();
        int lenOfMax = maxString.length();
        int temp = 0;
        int cur = 0;
        int i = lenOfMin - 1, j = lenOfMax - 1;
        for (; i >= 0 && j >= 0; i--, j--) {
            if (maxString.charAt(j) != minString.charAt(i)) {
                if (cur > temp) {
                    temp = cur;
                }
                cur = 0;
            } else {
                cur++;
            }
        }
        while (j-- > 0) {
            if (maxString.charAt(j) != '0') {
                cur++;
            } else {
                if (cur > temp) {
                    temp = cur;
                }
                cur = 0;
            }
        }
        return temp + 1;
    }
}
