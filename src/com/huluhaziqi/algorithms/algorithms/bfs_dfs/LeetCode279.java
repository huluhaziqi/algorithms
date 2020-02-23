package com.huluhaziqi.algorithms.algorithms.bfs_dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode279 {
    /**
     * 279. Perfect Squares
     * Medium
     * <p>
     * 2142
     * <p>
     * 165
     * <p>
     * Add to List
     * <p>
     * Share
     * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
     * <p>
     * Example 1:
     * <p>
     * Input: n = 12
     * Output: 3
     * Explanation: 12 = 4 + 4 + 4.
     * Example 2:
     * <p>
     * Input: n = 13
     * Output: 2
     * Explanation: 13 = 4 + 9.
     * Accepted
     * 243,883
     * Submissions
     * 548,224
     */
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

    class Solution3 {
        public int numSquares(int n) {
            if (n <= 0) {
                return 0;
            }
            Queue<Integer> queue = new LinkedList<>();
            List<Integer> list = generateSquares(n);
            int lenList = list.size();
            queue.offer(n);
            int index = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    int top = queue.poll();
                    for (int i = lenList - 1; i >= 0; i--) {

                        int value = list.get(i);
                        if (value > top) {
                            continue;
                        }
                        int tem = top - value;
                        if (tem == 0) {
                            return index;
                        } else {
                            queue.offer(tem);
                        }
                    }
                }
                index++;

            }

            return 0;
        }

        private List<Integer> generateSquares(int n) {
            if (n <= 0) {
                return new ArrayList<>();
            }
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (i * i <= n) {
                    list.add(i * i);
                }
            }
            return list;
        }

    }

    class Solution2 {

        public int numSquares(int n) {
            List<Integer> squares = generate(n);
            if (squares.size() == 0) {
                return 0;
            }
            Queue<Integer> queue = new LinkedList<>();
            int[] mark = new int[n + 1];
            queue.add(n);
            int num = 0;
            while (!queue.isEmpty()) {
                num++;
                int size = queue.size();
                while (size-- > 0) {
                    int tem = queue.poll();
                    for (int square : squares) {
                        int next = tem - square;
                        if (next < 0) {
                            break;
                        }
                        if (next == 0) {
                            return num;
                        }
                        if (mark[next] == 1) {
                            continue;
                        }
                        mark[next] = 1;
                        queue.add(next);
                    }
                }
            }
            return n;
        }

        List<Integer> generate(int n) {
            List<Integer> list = new ArrayList<>();

            int tem = 1;
            int diff = 3;
            while (tem <= n) {
                list.add(tem);
                tem += diff;
                diff += 2;
            }
            return list;
        }
    }

    class Solution4 {
        public int numSquares(int n) {
            if (n <= 0) {
                return 0;
            }
            int[] dp = new int[n + 1];
            dp[1] = 1;
            List<Integer> list = generateSquares(n);
            for (int k = 2; k <= n; k++) {
                dp[k] = Integer.MAX_VALUE;
                for (int i = 0; i < list.size(); i++) {
                    int value = list.get(i);
                    if (value > k) {
                        continue;
                    }
                    dp[k] = Math.min(dp[k], dp[k - value] + 1);
                }
            }

            return dp[n];
        }

        private List<Integer> generateSquares(int n) {
            if (n <= 0) {
                return new ArrayList<>();
            }
            List<Integer> list = new ArrayList<>();
            int tem = 1;
            int diff = 3;
            while (tem <= n) {
                list.add(tem);
                tem += diff;
                diff += 2;
            }
            return list;
        }

    }

}
