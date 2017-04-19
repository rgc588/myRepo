package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/18/2017.
 */
public class _59_M_SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] rst = new int[n][n];
        int count = 1;
        int rowS = 0;
        int rowE = n-1;
        int colS = 0;
        int colE = n-1;
        while(rowS < rowE && colS < colE) {
            for (int i = colS; i < colE; i++) {
                rst[rowS][i] = count++;
            }
            //rowS++;
            for (int i = rowS; i < rowE; i++) {
                rst[i][colE] = count++;
            }
            //colE--;
            for (int i = colE; i > colS; i--) {
                rst[rowE][i] = count++;
            }
            //rowE--;
            for (int i = rowE; i > rowS; i--) {
                rst[i][colS] = count++;
            }
            //colS++;
            rowS++;
            rowE--;
            colS++;
            colE--;
        }
        if(rowS == rowE) rst[rowS][colS] = count;//can remove
        return rst;
    }
}
