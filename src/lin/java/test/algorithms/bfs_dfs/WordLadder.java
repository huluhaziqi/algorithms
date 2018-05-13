package lin.java.test.algorithms.bfs_dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {

    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        int result = new WordLadder().ladderLength(begin,end,wordList);
        System.out.println(result);

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        if(!wordList.contains(endWord)){
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        int[] mark = new int[wordList.size()];
        queue.add(beginWord);
        int num = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            num++;
            while (size-- > 0) {
                String tem = queue.poll();
                for (int i = 0; i < wordList.size(); i++) {
                    String word = wordList.get(i);
                    if (mark[i] == 1) {
                        continue;
                    }
                    if (check(tem, word) && word.equals(endWord)) {
                        return num;
                    }
                    if (check(tem, word)) {
                        mark[i] = 1;
                        queue.add(word);
                    }
                }
            }
        }
        return 0;
    }

    public boolean check(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int num = 0;
        for (int i = 0; i < s.length() && num <= 1; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                num++;
            }
        }
        return num == 1 ? true : false;
    }
}
