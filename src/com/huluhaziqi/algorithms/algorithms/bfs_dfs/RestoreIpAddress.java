package com.huluhaziqi.algorithms.algorithms.bfs_dfs;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress {

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> ip = new ArrayList<>();
        ip = new RestoreIpAddress().restoreIpAddresses(s);
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
                prefix.delete(prefix.length() - tem.length()- 1 , prefix.length());
                level--;
            }
        }
    }

}
