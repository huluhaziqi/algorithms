package lin.java.test.algorithms.bfs_dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PerfectSquare {

    public static void main(String[] args) {
        int n = 12;
        List<Integer> list = new PerfectSquare().generate(n);
        int result = new PerfectSquare().numSquares2(n);
        System.out.println(result);
    }

    public int numSquares2(int n) {
        List<Integer> squares = generate(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n + 1];
        queue.add(n);
        marked[n] = true;
        int num = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            num++;
            while (size-- > 0) {
                int cur = queue.poll();
                for (int s : squares) {
                    int next = cur - s;
                    if (next < 0)
                        break;
                    if (next == 0)
                        return num;
                    if (marked[next])
                        continue;
                    marked[next] = true;
                    queue.add(cur - s);
                }
            }
        }
        return n;
    }

    public int numSquares(int n) {
        List<Integer> square = generate(n);
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            if (i - square.get(0) >= 0 && dp[i - square.get(0)] != Integer.MAX_VALUE) {
                dp[i] = dp[i - square.get(0)] + 1;
            }
        }
        for (int i = 1; i < square.size(); i++) {
            for (int j = 1; j <= n; j++) {
                if (j - square.get(i) >= 0 && dp[i - square.get(i)] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j - square.get(i)] + 1, dp[j]);
                }
            }
        }
        return dp[n];
    }

    List<Integer> generate(int n) {
        List<Integer> list = new ArrayList<>();

        int tem = 1;
        int diff = 3;
        while (tem <=n) {
            list.add(tem);
            tem += diff;
            diff += 2;
        }
        return list;
    }



}
