package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/15/2017.
 */
public class _221_M_MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        if (matrix.length == 0 || matrix[0].length == 0) return max;
        int[] mem = new int[matrix[0].length];
        int p = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int tmp = mem[j];
                if (i == 0 || j == 0) {
                    mem[j] = matrix[i][j] == '0' ? 0 : 1;
                } else {
                    mem[j] = matrix[i][j] == '0' ? 0 : Math.min(p, Math.min(mem[j],mem[j-1]))+1;
                }
                p = tmp;
                max = Math.max(max, mem[j]);
            }
        }
        return max*max;
    }
}
