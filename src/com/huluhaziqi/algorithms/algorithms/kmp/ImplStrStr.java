package com.huluhaziqi.algorithms.algorithms.kmp;

public class ImplStrStr {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a  ="bbcabcdab abcdabcdabdaa";
        String b = "abcdabd";
        solution.strStr(a,b);
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null){
            return 0;
        }
        int[] next = next(needle);
        int l1 = 0;
        int l2 = 0;
        while(l1 < haystack.length() && l2 < needle.length()){
            if(haystack.charAt(l1) == needle.charAt(l2)){
                l1++;
                l2++;
            }else{
                l2 = next[l2];
            }
        }
        if(l2 < needle.length()){
            return -1;
        }
        return l1 - l2;
    }

    int[] next(String sub){
        int[] next = new int[sub.length()];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while(j < sub.length() - 1){
            if(k == -1 || sub.charAt(j) == sub.charAt(k)){
                k++;
                j++;
                next[j] = k;
            }else{
                k = next[k];
            }
        }
        return next;
    }
}
