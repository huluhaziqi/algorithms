package com.huluhaziqi.algorithms.algorithms.backTracing;

import java.util.*;

public class PalindromePartitioning {

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> result = new PalindromePartitioning().partition(s);
        result.forEach(o->{
            o.forEach(p-> System.out.print(p + " "));
            System.out.print("     ");
        });
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backTracing(s,0,new ArrayList<>(),result);
        return result;
    }

    void backTracing(String s, int start, List<String> value, List<List<String>> ret) {
        if (start > s.length()) {
            return;
        }
        if (start == s.length()) {
            ret.add(new ArrayList<>(value));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String tem = s.substring(start, i + 1);
            if(!checkPal(s, start, i)){
                continue;
            }
            value.add(tem);
            backTracing(s,i + 1,value,ret);
            value.remove(value.size() - 1);
        }
    }

    boolean checkPal(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
