package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/19/2017.
 */
public class _62_M_UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[] cRow = new int[n];
        for (int i = 0; i < n; i++) {
            cRow[i]=1;
        }
        for (int i = 1; i < m; i++) {
            cRow[0] = 1;
            for (int j = 1; j < n; j++) {
                cRow[j] = cRow[j] + cRow[j-1];
            }
        }
        return cRow[n-1];
    }
}
