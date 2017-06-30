package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/18/2017.
 */
public class _240_M_Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length-1;
        int n = matrix[0].length-1;
        return helper(matrix, 0, m, 0, n, target);
    }

    private boolean helper(int[][] m, int rs, int re, int cs, int ce, int t) {
        if (rs > re || cs > ce) return false;
        int r = rs + (re - rs)/2;
        int c = cs + (ce - cs)/2;
        int v = m[r][c];
        if (t == v) return true;
        if (t < v) {
            return helper(m, rs, r-1, cs, c-1, t) || helper(m, r, re, cs, c-1, t) || helper(m, rs, r-1, c, ce, t);
        } else {
            return helper(m, r+1, re, c+1, ce, t) || helper(m, r+1, re, cs, c, t) || helper(m, rs, r, c+1, ce, t);
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{5},{6}};
        _240_M_Searcha2DMatrixII sol = new _240_M_Searcha2DMatrixII();
        System.out.print(sol.searchMatrix(input, 6));
    }
}
