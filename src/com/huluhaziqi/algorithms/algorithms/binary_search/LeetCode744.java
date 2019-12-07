package com.huluhaziqi.algorithms.algorithms.binary_search;

public class LeetCode744 {

    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            if(letters == null || letters.length == 0){
                return ' ';
            }
            int l = 0;
            int r = letters.length;
            while(l < r){
                int mid = l +(r - l) / 2;
                if(letters[mid] >= target){
                    r = mid;
                } else {
                    l = mid +1;
                }
            }
            return letters[l];
        }
    }

    class Solution2 {
        public char nextGreatestLetter(char[] letters, char target) {
            if(letters == null || letters.length == 0){
                return ' ';
            }
            int l = 0;
            int r = letters.length - 1;

            while(l <= r){
                int mid = l +(r - l) / 2;
                if(letters[mid] <= target){
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return l < letters.length ? letters[l] :letters[0];
        }
    }

    class Solution3 {
        public char nextGreatestLetter(char[] letters, char target) {
            if(letters == null || letters.length == 0){
                return ' ';
            }
            int l = 0;
            int r = letters.length - 1;
            if(target >= letters[r]){
                return letters[0];
            }
            while(l < r){
                int mid = l +(r - l) / 2;
                if(letters[mid] <= target){
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }

            return letters[l];
        }
    }
}
