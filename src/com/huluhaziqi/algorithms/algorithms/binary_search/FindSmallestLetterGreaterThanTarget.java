package com.huluhaziqi.algorithms.algorithms.binary_search;

public class FindSmallestLetterGreaterThanTarget {

    public static void main(String[] args) {
        char[] letters = {'c','f','j'};
        char target = 'a';
        char result = new FindSmallestLetterGreaterThanTarget().nextGreatestLetter(letters,target);
        System.out.println(result);
    }

    public char nextGreatestLetter(char[] letters, char target) {
        if(letters == null || letters.length == 0){
            return 0;
        }
        int l = 0;
        int r = letters.length - 1;
        while (l < r){
            int mid = l + (r - l) / 2;
            if(letters[mid] >= target){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        if(letters[l] == target){
            l++;
        }
        return letters[l];
    }
}
