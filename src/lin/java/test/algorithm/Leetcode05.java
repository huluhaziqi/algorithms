package lin.java.test.algorithm;

import java.util.Scanner;

public class Leetcode05 {
    // Longest Palindromic Substring

    /**
     * Example:
     * <p>
     * Input: "babad"
     * <p>
     * Output: "bab"
     * <p>
     * Note: "aba" is also a valid answer.
     * Example:
     * <p>
     * Input: "cbbd"
     * <p>
     * Output: "bb"
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String result = longestPalindrome2(s);
            System.out.println(result);
        }
    }

    public static String longestPalindrome2(String s) {
        //use db
        boolean[][] arr = new boolean[s.length()][s.length()];
        int len = 0, left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                arr[j][i] = (s.charAt(i) == s.charAt(j) && (i - j < 2 || arr[j + 1][i - 1]));
                if (arr[j][i] && len < i - j + 1) {
                    left = j;
                    right = i;
                    len = i - j + 1;
                }
            }
            arr[i][i] = true;
        }
        return s.substring(left,right + 1);
    }

    public static String longestPalindrome(String s) {
        int maxLen = 0;
        String result = null;
        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(judge(s, i, i), judge(s, i - 1, i));
            if (len > maxLen) {
                maxLen = len;
                result = s.substring(i - maxLen / 2, i - maxLen / 2 + maxLen);
            }
        }
        return result;
    }

    public static int judge(String s, int i, int j) {
        if (i > j || i < 0 || j >= s.length()) {
            return 0;
        }
        int maxLen = 0;
        while (i >= 0 && j <= s.length() - 1 && (s.charAt(i) == s.charAt(j))) {
            i--;
            j++;
        }
        return j - i - 1;
    }

    public static int judge1(String s, int index) {
        if (index < 0 || index >= s.length()) {
            return 0;
        }
        int i = index, j = index;
        int maxLen = 0;
        while (i >= 0 && j <= s.length() - 1) {
            if (s.charAt(i) == s.charAt(j)) {
                maxLen = (i == j) ? (maxLen + 1) : (maxLen + 2);
            } else {
                break;
            }
            i--;
            j++;
        }
        return maxLen;
    }

    public static int judge2(String s, int index) {
        if (index < 0 || index >= s.length()) {
            return 0;
        }
        int i = index - 1, j = index;
        if (i < 0) {
            return 0;
        }
        int maxLen = 0;
        while (i >= 0 && j <= s.length() - 1) {
            if (s.charAt(i) == s.charAt(j)) {
                maxLen = maxLen + 2;
            } else {
                break;
            }
            i--;
            j++;
        }
        return maxLen;
    }

}
