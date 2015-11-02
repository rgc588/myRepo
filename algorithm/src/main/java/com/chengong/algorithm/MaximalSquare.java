package com.chengong.algorithm;

/**
 * Created by chengong on 9/15/15.
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;

        int max = 0;
        for(int i = 0; i < matrix[0].length; i++) {
            matrix[0][i] = value(matrix[0][i]);
            if(matrix[0][i] > max) max = matrix[0][i];
        }

        /**
         * i = 0 case is already handled, should not revisit
         */
        for(int i = 1; i < matrix.length; i++) {
            matrix[i][0] = value(matrix[i][0]);
            if(matrix[i][0] > max) max = matrix[i][0];
        }

        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][j] == '1') {
                    char temp = (char) (Math.min(Math.min(matrix[i - 1][j],matrix[i][j - 1]), matrix[i - 1][j - 1]) + 1);
                    if(temp > max) max = temp;
                    matrix[i][j] = temp;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        return max*max;
    }

    //only use when c == '1' or c == '0'
    private char value(char c) {
        if(c == '1') return 1;
        else return 0;
    }

    public static void main(String[] args) {
        char[][] testInput = new char[][] {{'1', '1'},
                                            {'1', '1'}};
        System.out.println(new MaximalSquare().maximalSquare(testInput));
    }
}
