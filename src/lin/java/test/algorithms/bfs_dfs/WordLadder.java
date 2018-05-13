package lin.java.test.algorithms.bfs_dfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {

    public static void main(String[] args) {

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || wordList.size() == 0){
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int num = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            num++;
            while (size-- > 0){

            }
        }
    }
}
