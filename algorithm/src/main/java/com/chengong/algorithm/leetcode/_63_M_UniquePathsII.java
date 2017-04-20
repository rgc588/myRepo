package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/19/2017.
 */
public class _63_M_UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] o = obstacleGrid;
        if (o.length == 0 || o[0].length == 0) return 0;
        int m = o.length;
        int n = o[0].length;
        o[0][0] = o[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < n; i++) {
            o[0][i] = o[0][i] == 1 ? 0 : o[0][i-1];
        }
        for (int i = 1; i < m; i++) {
            o[i][0] = o[i][0] == 1 ? 0 : o[i-1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (o[i][j] == 1) {
                    o[i][j] = 0;
                } else {
                    o[i][j] = o[i-1][j] + o[i][j-1];
                }
            }
        }
        return o[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {{0},{0}};
        _63_M_UniquePathsII sol = new _63_M_UniquePathsII();
        int rst = sol.uniquePathsWithObstacles(input);
        System.out.print(rst);
    }
}
