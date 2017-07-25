package com.chengong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cheng on 6/26/2017.
 */
public class _305_H_NumberofIslandsII {
    public List<Integer> numIslands1(int m, int n, int[][] positions) {
        List<Integer> rst = new ArrayList<>();
        if(m == 0 || n == 0) return rst;
        int[] p = new int[m*n];
        Arrays.fill(p, -1);
        int[][] dirct = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
        int count = 0;
        for (int[] pos : positions) {
            int index = pos[0]*n+pos[1];
            p[index] = index;
            count++;
            for (int[] d : dirct) {
                int i = pos[0]+d[0];
                int j = pos[1]+d[1];
                int index2 = i*n+j;
                if (i < 0 || i >= m || j < 0 || j >= n || p[index2] == -1) continue;
                int p1 = find(p, index);
                int p2 = find(p, index2);
                if (p1 != p2) {
                    count--;
                    p[p2] = p1;
                }
            }
            rst.add(count);
        }
        return rst;
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] matrix = new int[m][n];
        int[][] dirct = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
        int total = 0;
        List<Integer> rst = new ArrayList<>();
        if (m == 0 || n == 0) return rst;
        for (int[] p : positions) {
            boolean[][] visited = new boolean[m][n];
            int count = 0;
            for (int[] d : dirct) {
                int i = p[0]+d[0];
                int j = p[1]+d[1];
                if (i >= 0 && i < m && j >= 0 && j < n && !visited[i][j] && matrix[i][j] == 1) {
                    search(matrix, visited, i, j, dirct, m, n);
                    count++;
                }
            }
            matrix[p[0]][p[1]] = 1;
            total += (1-count);
            rst.add(total);
        }
        return rst;
    }

    private void search(int[][] matrix, boolean[][] visited, int i, int j, int[][] dirct, int m, int n) {
        visited[i][j] = true;
        for (int[] d : dirct) {
            int ii = i + d[0];
            int jj = j + d[1];
            if (ii >= 0 && ii < m && jj >= 0 && jj < n && !visited[ii][jj] && matrix[ii][jj] == 1) search(matrix, visited, ii, jj, dirct, m, n);
        }
    }

    private int find(int[] p, int index) {
        int tmp = index;
        while(index != p[index]) {
            index = p[index];
        }
        p[tmp] = index;
        return index;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{0, 1}, {1, 2}, {2, 1}, {1, 0}, {0, 2}, {0, 0}, {1, 1}};
        _305_H_NumberofIslandsII sol = new _305_H_NumberofIslandsII();
        System.out.print(sol.numIslands2(3, 3, input));
    }
}
