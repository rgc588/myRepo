package com.chengong.algorithm;

/**
 * Created by chengong on 11/13/15.
 */
public class RangeSumQuery2DImmutable {
    public static class NumMatrix {
        int[][] m;

        public NumMatrix(int[][] matrix) {
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                this.m = new int[0][0];
                return;
            }
            this.m = new int[matrix.length][matrix[0].length];
            m[0][0] = matrix[0][0];
            for(int i = 1; i < m.length; i++) {
                m[i][0] = matrix[i][0] + m[i - 1][0];
            }

            for(int j = 1; j < m[0].length; j++) {
                m[0][j] = m[0][j - 1] + matrix[0][j];
            }

            for(int i = 1; i < m.length; i++) {
                for(int j = 1; j < m[i].length; j++) {
                    m[i][j] = matrix[i][j] + m[i][j - 1] + m[i - 1][j] - m[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if(m == null || m.length == 0 || m[0].length == 0) return 0;
            int leftDown = 0;
            int rightTop = 0;
            int leftTop = 0;

            if(col1 - 1 >= 0) leftDown = m[row2][col1 -1];
            if(row1 - 1 >= 0) rightTop = m[row1 - 1][col2];
            if(row1 - 1 >= 0 && col1 - 1 >= 0) leftTop = m[row1 -1][col1- 1];
            return m[row2][col2] - leftDown - rightTop + leftTop;
        }
    }

    public static void main(String[] args) {
        int[][] m = new int[][] {{-1}};
        NumMatrix test = new NumMatrix(m);
        System.out.println(test.sumRegion(0, 0, 0, 0));
    }
}
