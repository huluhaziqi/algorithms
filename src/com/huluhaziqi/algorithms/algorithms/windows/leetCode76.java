package com.huluhaziqi.algorithms.algorithms.windows;

import java.util.HashMap;
import java.util.Map;

public class leetCode76 {
    class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> hs = new HashMap<>();
            Map<Character, Integer> ht = new HashMap<>();
            for (char c : t.toCharArray()) {
                ht.put(c, ht.getOrDefault(c, 0) + 1);
            }
            String res = "";
            int len = Integer.MAX_VALUE;
            int cnt = 0;
            for (int i = 0, j = 0; i < s.length(); i++) {
                hs.put(s.charAt(i), hs.getOrDefault(s.charAt(i), 0) + 1);
                if (ht.containsKey(s.charAt(i)) && hs.get(s.charAt(i)) <= ht.get(s.charAt(i))) cnt++;
                while (j < i && (hs.containsKey(s.charAt(j)) || hs.get(s.charAt(j)) > ht.get(s.charAt(j)))) {
                    hs.put(s.charAt(j), hs.get(s.charAt(j)) - 1);
                    j++;
                }
                if (cnt == t.length() && i - j + 1 < len) {
                    res = s.substring(j, i + 1);
                    len = i - j + 1;
                }
            }
            return res;
        }
    }
}
