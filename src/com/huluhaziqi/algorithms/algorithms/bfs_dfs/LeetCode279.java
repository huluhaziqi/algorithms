package com.huluhaziqi.algorithms.algorithms.bfs_dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode279 {
    class Solution {
        public int numSquares(int n) {
            if (n <= 0) {
                return 0;
            }
            Queue<Integer> queue = new LinkedList<>();
            List<Integer> s = generateSquares(n);
            queue.add(n);
            int result = 0;
            boolean[] visited = new boolean[n + 1];
            while (!queue.isEmpty()) {
                int len = queue.size();
                while ((len-- > 0)) {
                    int top = queue.poll();
                    if (top < 0) {
                        continue;
                    }
                    if (top == 0) {
                        return result;
                    }
                    if (visited[top]) {
                        continue;
                    }
                    for (int i = s.size() - 1; i >= 0; i--) {
                        if (s.get(i) <= top) {
                            queue.offer(top - s.get(i));
                            visited[top] = true;
                        }
                    }
                }
                result++;
            }
            return -1;
        }

        private List<Integer> generateSquares(int n) {
            List<Integer> squares = new ArrayList<>();
            int square = 1;
            int diff = 3;
            while (square <= n) {
                squares.add(square);
                square += diff;
                diff += 2;
            }
            return squares;
        }

    }

    List<Integer> square(int n) {
        List<Integer> s = new LinkedList<>();
        for (int i = 1; i <= Math.sqrt(n) + 1; i++) {
            if (i * i <= n) {
                s.add(i * i);
            }
        }
        return s;
    }


}
