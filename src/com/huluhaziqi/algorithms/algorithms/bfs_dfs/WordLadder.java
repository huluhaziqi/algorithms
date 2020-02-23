package com.huluhaziqi.algorithms.algorithms.bfs_dfs;

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
        int result = new WordLadder().ladderLength(begin, end, wordList);
        System.out.println(result);

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        if (!wordList.contains(endWord)) {
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


    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {

            if (wordList == null || wordList.size() == 0 || !wordList.contains(endWord)) {
                return 0;
            }
            int len = wordList.size();
            boolean[] visited = new boolean[len];
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            int index = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    String top = queue.poll();
                    for (int i = 0; i < len; i++) {
                        if (top.equals(endWord)) {
                            return index;
                        }
                        if (visited[i]) {
                            continue;
                        }
                        if (!checkDis(top, wordList.get(i))) {
                            continue;
                        }
                        visited[i] = true;
                        queue.offer(wordList.get(i));
                    }
                }
                index++;
            }
            return 0;
        }

        boolean checkDis(String s1, String s2) {
            int len = s1.length();
            int count = 0;
            for (int i = 0; i < len; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    count++;
                    if (count > 1) {
                        return false;
                    }
                }
            }
            return count == 1 ? true : false;
        }

    }
}
