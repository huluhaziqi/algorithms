package lin.java.test.algorithm;

import java.util.Scanner;

public class LeetCode03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            int result = lengthOfLongestSubstring(s);
            System.out.println(result);
        }
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] arr = new int[256];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = -1;
        }
        int maxLen = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (arr[s.charAt(i)] != -1) {
                cur = Math.max(arr[s.charAt(i)] + 1, cur);
            }
            maxLen = Math.max(maxLen, i - cur + 1);
            arr[s.charAt(i)] = i;
        }
        return maxLen;
    }


    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] array = new int[256];
        for (int i = 0; i < array.length; ++i) {
            array[i] = -1;
        }
        int cur = 0;
        int maxLen = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (array[s.charAt(i)] != -1) {
                cur = Math.max(i, cur);
            }
            maxLen = Math.max(maxLen, i - cur + 1);
            array[s.charAt(i)] = i;
        }
        return maxLen;
    }
}
