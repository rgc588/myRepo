package com.chengong.algorithm;

import java.util.Arrays;

/**
 * Created by chengong on 10/5/15.
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                int v = board[i][j];
                int c = count(board, i, j);
                if(v == 0 && c == 3) {
                    board[i][j] = 2;//0->1
                } else if(v == 1 && (c == 2 || c == 3)){
                    board[i][j] = 3;//1->1
                }
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = board[i][j]>>1;
            }
        }
    }

    private int count(int[][] board, int i, int j) {
        int c = 0;
        int m = i-1 >= 0 ? i-1 : 0;
        for(;m < board.length && m <= i+1; m++) {
            int n = j-1 >= 0 ? j-1 : 0;
            for(;n < board[m].length && n <= j+1; n++) {
                if(!(m == i && n == j)) {
                    c += board[m][n]%2;
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
        GameOfLife sol = new GameOfLife();

        int[][] test = new int[][] {{1, 1},{1, 0}};
        sol.gameOfLife(test);
        System.out.println(Arrays.deepToString(test));
    }
}
