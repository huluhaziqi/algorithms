package com.huluhaziqi.algorithms.algorithms.binary_search;

public class LeetCode744 {

    /**
     * 744. Find Smallest Letter Greater Than Target
     * Easy
     * <p>
     * Share
     * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.
     * <p>
     * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
     * <p>
     * Examples:
     * Input:
     * letters = ["c", "f", "j"]
     * target = "a"
     * Output: "c"
     * <p>
     * Input:
     * letters = ["c", "f", "j"]
     * target = "c"
     * Output: "f"
     * <p>
     * Input:
     * letters = ["c", "f", "j"]
     * target = "d"
     * Output: "f"
     * <p>
     * Input:
     * letters = ["c", "f", "j"]
     * target = "g"
     * Output: "j"
     * <p>
     * Input:
     * letters = ["c", "f", "j"]
     * target = "j"
     * Output: "c"
     * <p>
     * Input:
     * letters = ["c", "f", "j"]
     * target = "k"
     * Output: "c"
     * Note:
     * letters has a length in range [2, 10000].
     * letters consists of lowercase letters, and contains at least 2 unique letters.
     * target is a lowercase letter.
     */
    class Solution2 {
        public char nextGreatestLetter(char[] letters, char target) {
            if (letters == null || letters.length == 0) {
                return ' ';
            }
            int l = 0;
            int r = letters.length - 1;

            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (letters[mid] <= target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return l < letters.length ? letters[l] : letters[0];
        }
    }

    class Solution3 {
        public char nextGreatestLetter(char[] letters, char target) {
            if (letters == null || letters.length == 0) {
                return ' ';
            }
            int l = 0;
            int r = letters.length - 1;
            if (target >= letters[r]) {
                return letters[0];
            }
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (letters[mid] <= target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }

            return letters[l];
        }
    }

    /**
     * 找到左边比目标值大的第一个，
     * char  <= target , l = mid + 1;
     * char > target r = mid - 1;
     */
    class Solution4 {
        public char nextGreatestLetter(char[] letters, char target) {
            if (letters == null || letters.length == 0) {
                return ' ';
            }
            int l = 0;
            int r = letters.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (letters[mid] <= target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return l >= letters.length ? letters[0] : letters[l];
        }
    }
}
