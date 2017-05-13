package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/8/2017.
 */
public class _200_M_NumberofIslands {
    public int numIslands(char[][] grid) {
        if (grid == null) return 0;
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    helper(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void helper(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if (grid[i][j] == '0') return;
        grid[i][j] = '0';
        helper(grid, i+1,j);
        helper(grid, i-1,j);
        helper(grid, i,j+1);
        helper(grid, i,j-1);
    }
}
