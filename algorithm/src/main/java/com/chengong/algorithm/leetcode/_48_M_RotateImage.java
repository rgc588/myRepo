package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/17/2017.
 */
public class _48_M_RotateImage {
    public void rotate(int[][] matrix) {
        int i = 0;
        int j = matrix.length-1;
        while(i < j) {
            for (int m = 0; m < matrix[i].length; m++) {
                swap(matrix, i, j, m, m);
            }
            i++;
            j--;
        }
        for (int p = 0; p < matrix.length; p++) {
            for (int q = p+1; q < matrix[p].length; q++) {
                swap(matrix, p, q, q, p);
            }
        }
    }

    private void swap(int[][] m, int i, int j, int p, int q) {
        m[i][p] = m[i][p]^m[j][q];
        m[j][q] = m[i][p]^m[j][q];
        m[i][p] = m[i][p]^m[j][q];
    }
}
