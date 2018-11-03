package lin.java.test.algorithms.algorithm;

import java.util.Arrays;

public class LeetCode14 {
}

class Solution14 {


    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length <= 1) {
            return "";
        }
        int len = strs.length;
        String first = strs[0];
        int i = 0;
        for (int j = 1; j < len; j++) {
            if ((i <= strs[0].length() && isPrefix(first.substring(0, i), strs[j]))) {
                continue;
            } else {
                return strs[0].substring(0, i - 1);
            }
        }
        return first;
    }

    public boolean isPrefix(String sub, String s) {
        if (sub == null || s == null || sub.length() > s.length()) {
            return false;
        }
        if (sub.length() == 0) {
            return true;
        }
        int lenSub = sub.length();
        return sub.equals(s.substring(0, lenSub));

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int len = strs.length;
        String pre = strs[0];
        for(int i = 1; i < len;i++){
            while (strs[i].indexOf(pre) != 0){
                pre = pre.substring(0,pre.length() - 1);
            }
        }
        return pre;
    }

    public String longestCommonPrefix3(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder();
        int n = Math.min(strs[0].length(),strs[strs.length - 1].length());
        for(int i = 0; i < n; i++){
            if(strs[0].charAt(i) == strs[strs.length - 1].charAt(i)){
                sb.append(strs[0].charAt(i));
            }else{
                break;
            }
        }
        return sb.toString();
    }
}