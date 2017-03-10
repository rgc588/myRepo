package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 3/9/2017.
 */
public class M498DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new int[0];
        int n = matrix[0].length;
        boolean up = true;
        int[] rst = new int[m*n];
        int index = 0;
        for (int l = 0; l < m + n - 1; l++) {
            if (up) {
                int i = l < m ? l : m - 1;
                int j = Math.max(0, l - m + 1);
                while(i >= 0 && j < n) {
                    rst[index++] = matrix[i][j];
                    i--;
                    j++;
                }
            } else {
                int i = Math.max(0, l - n + 1);
                int j = l < n ? l : n - 1;
                while (j >= 0 && i < m) {
                    rst[index++] = matrix[i][j];
                    i++;
                    j--;
                }
            }
            up = !up;
        }
        return rst;
    }

    public int[] findDiagonalOrder2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;

        int[] result = new int[m * n];
        int row = 0, col = 0, d = 0;
        int[][] dirs = {{-1, 1}, {1, -1}};

        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[row][col];
            row += dirs[d][0];
            col += dirs[d][1];

            if (row >= m) { row = m - 1; col += 2; d = 1 - d;}
            if (col >= n) { col = n - 1; row += 2; d = 1 - d;}
            if (row < 0)  { row = 0; d = 1 - d;}
            if (col < 0)  { col = 0; d = 1 - d;}
        }

        return result;
    }
}
