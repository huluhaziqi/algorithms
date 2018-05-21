package lin.java.test.algorithms.dynamic_programming;

import java.util.*;

public class WordBreak {

    /**
     "catsandog"
     ["cats","dog","sand","and","cat"]
     */
    public static void main(String[] args) {

        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats","dog","sand","and","cat");
        boolean result = new WordBreak().wordBreak2(s,wordDict);
        System.out.println(result);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        Set<List<String>> result = getAll(wordDict, wordDict.size() - 1);
        for (List<String> r : result) {
            StringBuilder sb = new StringBuilder();
            for (String sub : r) {
                sb.append(sub);
            }
            if (sb.length() != 0 && s.contains(sb.toString())) {
                return true;
            }
        }
        return false;
    }

    public Set<List<String>> getAll(List<String> wordDict, int x) {
        Set<List<String>> result = new HashSet<>();
        if (x < 0) {
            return null;
        }
        if (x == 0) {
            List<String> tem = new LinkedList<>();
            tem.add(wordDict.get(0));
            result.add(tem);
            return result;
        }
        Set<List<String>> sub = getAll(wordDict, x - 1);
        sub.forEach(o -> {
            for (int i = 0; i <= x; i++) {
                List<String> tem = new LinkedList<>(o);
                tem.add(i, wordDict.get(x));
                if(!result.contains(tem)) {
                    result.add(tem);
                }
            }
        });
        return result;
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (String word : wordDict) {
                int size = word.length();
                if (size <= i && word.equals(s.substring(i - size,i))) {
                    dp[i] = dp[i] || dp[i - size];
                }
            }
        }
        return dp[len];
    }
}
