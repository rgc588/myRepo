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
                if(v >= 10) {
                    v = v/10 == 1 ? 1 : 0;
                }
                if(v == 1) {
                    update(board, i, j);
                }
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                int v = board[i][j]/10 == 1 ? 1 : 0;
                int c = board[i][j]%10;
                if((v == 1 && c <= 3 && c >= 2) ||
                        (v == 0 && c == 3)) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }

    private void update(int[][] board, int i, int j) {
        for(int m = i - 1; m <= i + 1; m++) {
            if(m >= 0 && m < board.length) {
                for(int n = j - 1; n <= j + 1; n++) {
                    if(n >= 0 && n < board[m].length) {
                        if(m != i || n != j) {
                            if(board[m][n] < 10) {
                                board[m][n] = board[m][n] == 1 ? 10 : 20;
                            }
                            board[m][n] += 1;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        GameOfLife sol = new GameOfLife();

        int[][] test = new int[][] {{1, 1},{1, 0}};
        sol.gameOfLife(test);
        System.out.println(Arrays.deepToString(test));
    }
}
