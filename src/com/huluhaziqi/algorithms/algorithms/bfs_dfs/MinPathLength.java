package com.huluhaziqi.algorithms.algorithms.bfs_dfs;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class MinPathLength {

    public static void main(String[] args) {
        int[][] grids = {{0,1,1,0,0,1,1},
                {1,0,0,0,0,0,0},
                {1,0,0,0,0,0,0},
                {0,0,0,0,1,1,0},
                {0,0,0,1,0,1,1},
                {1,0,0,1,1,0,0},
                {1,0,0,0,1,0,0}
    };
        int tc = 6;
        int tr = 6;
        int result = new MinPathLength().minPathLength(grids, tr, tc);
        System.out.println(result);
    }

    public int minPathLength(int[][] grids, int tr, int tc) {
        if (grids == null || grids.length == 0 || grids[0].length == 0) {
            return -1;
        }
        int[][] direct = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int row = grids.length;
        int col = grids[0].length;
        queue.add(new Pair<>(0, 0));
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                Pair<Integer, Integer> tem = queue.poll();
                for (int[] d : direct) {
                    Pair<Integer, Integer> next = new Pair<>(tem.getKey() + d[0], tem.getValue() + d[1]);
                    if (next.getKey() < 0 || next.getKey() >= row || next.getValue() < 0 || next.getValue() >= col) {
                        continue;
                    }
                    if (grids[next.getKey()][next.getValue()] == 1) {
                        grids[next.getKey()][next.getValue()] = 0;
                        if (next.getKey() == tr && next.getValue() == tc) {
                            return level;
                        } else {
                            queue.add(next);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
