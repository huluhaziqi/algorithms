package com.huluhaziqi.algorithms.algorithms.bfs_dfs;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress {

    public static void main(String[] args) {
//        String s = "25525511135";
//        List<String> ip = new ArrayList<>();
//        ip = new RestoreIpAddress().restoreIpAddresses(s);
//        ip.forEach(o -> System.out.println(o));
        String s = "25525511135";
        List<String> ip = new ArrayList<>();
        ip = new Solution2().restoreIpAddresses(s);
        ip.forEach(o -> System.out.println(o));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        combine(new StringBuilder(), 0, s, result);
        return result;
    }

    public void combine(StringBuilder prefix, int level, String s, List<String> ret) {
        if (prefix.length() == s.length() + 4 && level == 4) {
            ret.add(prefix.substring(1, prefix.length()));
            return;
        }
        if (level == 4) {
            return;
        }
        for (int i = 1, index = prefix.length() - level; i <= 3 && index + i <= s.length(); i++) {
            if (i != 1 && s.charAt(index) == '0') {
                break;
            }
            String tem = s.substring(index, index + i);
            System.out.println("tem " + tem);
            int next = Integer.parseInt(tem);
            if (next <= 255) {
                prefix.append("." + tem);
                level++;
                System.out.println(prefix.toString());
                combine(prefix, level, s, ret);
                prefix.delete(prefix.length() - tem.length() - 1, prefix.length());
                level--;
            }
        }
    }

    static class Solution2 {
        public List<String> restoreIpAddresses(String s) {
            if (s == null || s.length() == 0) {
                return ips;
            }
            backtracing(s, 0, 0, new StringBuilder());
            return ips;
        }

        List<String> ips = new ArrayList<>();

        void backtracing(String s, int index, int len, StringBuilder sb) {
            if (index == 4 || len >= s.length()) {
                if (index == 4 && len == s.length()) {
                    ips.add(sb.substring(1, sb.length()));
                }
                return;

            }
            index++;
            int tem = len;
            for (int i = 0; i < 3 && tem + i + 1 <= s.length(); i++) {
                String tem1 = s.substring(tem, tem + i + 1);
                int value = Integer.parseInt(tem1);
                if (value > 255 || value < 0) {
                    continue;
                }
                len += (i + 1);
                sb.append("." + s.substring(tem, tem + i + 1));
                backtracing(s, index, len, sb);
                sb.delete(sb.length() - i - 2, sb.length());
                len -= i + 1;
            }
        }
    }

    class Solution {
        public List<String> restoreIpAddresses(String s) {
            if (s == null || s.length() == 0) {
                return ips;
            }
            backtracing(s, 0, new StringBuilder());
            return ips;
        }

        List<String> ips = new ArrayList<>();

        void backtracing(String s, int index, StringBuilder sb) {
            if (index == 4) {
                if (0 == s.length()) {
                    ips.add(sb.substring(1, sb.length()));
                }
                return;

            }
            index++;
            for (int i = 0; i < 3 && i + 1 <= s.length(); i++) {
                if (i != 0 && s.charAt(0) == '0') {
                    continue;
                }
                String tem1 = s.substring(0, i + 1);
                int value = Integer.parseInt(tem1);
                if (value > 255 || value < 0) {
                    continue;
                }
                sb.append("." + s.substring(0, i + 1));
                backtracing(s.substring(i + 1), index, sb);
                sb.delete(sb.length() - i - 2, sb.length());
            }
        }
    }

        public List<String> restoreIpAddresses3(String s) {
            List<String>  list = new ArrayList<>();
            if(s == null || s.length() == 0){
                return list;
            }
            address(new StringBuilder(), s, 0, list);
            return list;
        }

        void address(StringBuilder temp, String s, int index, List<String> list){
            if(index == 4 || s.length() == 0){
                if(index == 4 && s.length() == 0){
                    list.add(temp.toString());
                }
                return;
            }

            for(int i = 0; i < 3; i++){
                if(i != 0 && s.charAt(0) == '0'){
                    break;
                }
                String sub = s.substring(0, i + 1);
                int next = Integer.valueOf(sub);
                if(next <= 255){
                    if(temp.length() != 0){
                        sub = '.' + sub;
                    }
                    temp.append(sub);
                    address(temp,s.substring(i + 1), index + 1, list);
                    temp.delete(temp.length() - sub.length(), temp.length());
                }

            }
        }

}
