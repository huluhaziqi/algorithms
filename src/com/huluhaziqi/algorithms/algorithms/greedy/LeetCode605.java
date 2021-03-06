package com.huluhaziqi.algorithms.algorithms.greedy;

public class LeetCode605 {

    /**
     * 605. Can Place Flowers
     * Easy
     * <p>
     * Share
     * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
     * <p>
     * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
     * <p>
     * Example 1:
     * Input: flowerbed = [1,0,0,0,1], n = 1
     * Output: True
     * Example 2:
     * Input: flowerbed = [1,0,0,0,1], n = 2
     * Output: False
     * Note:
     * The input array won't violate no-adjacent-flowers rule.
     * The input array size is in the range of [1, 20000].
     * n is a non-negative integer which won't exceed the input array size.
     */
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            if (flowerbed == null || flowerbed.length == 0 || flowerbed.length < n) {
                return false;
            }
            int count = 0;
            for (int i = 0; i < flowerbed.length; i++) {
                int pre = i == 0 ? 0 : flowerbed[i - 1];
                int next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
                if (pre == 0 && next == 0 && flowerbed[i] == 0) {
                    count++;
                    flowerbed[i] = 1;

                }
                if (count >= n) {
                    return true;
                }
            }
            return false;
        }
    }

    class Solution2 {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            if (flowerbed == null || flowerbed.length == 0 || flowerbed.length < n) {
                return false;
            }
            int count = 0;
            for (int i = 0; i < flowerbed.length; i++) {
                int pre = 0;
                int next = 0;
                if (flowerbed[i] == 0) {
                    pre = (i == 0) ? 0 : flowerbed[i - 1];
                    next = (flowerbed.length - 1 == i) ? 0 : flowerbed[i + 1];
                    if (pre == 0 && next == 0) {
                        count++;
                        flowerbed[i] = 1;
                    }
                }
            }
            if (count >= n) {
                return true;
            }
            return false;
        }
    }
}
