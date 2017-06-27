package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/22/2017.
 */
public class _289_M_GameofLife {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int count = count(board, i, j);
                if ((board[i][j]%10 == 1 && count >=2 && count <=3)
                        || (board[i][j]%10 == 0 && count ==3)) {
                    board[i][j] += 10;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] /= 10;
            }
        }
    }

    private int count(int[][] b, int i, int j) {
        int count = 0;
        for (int m = i-1; m <= i+1; m++) {
            for (int n = j-1; n<= j+1; n++) {
                if (!(m == i && n == j) && m > 0 && n > 0 && m < b.length && n < b[i].length) count += b[m][n]%10;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] board = new int[][] {{1,1},{1,0}};
        _289_M_GameofLife sol = new _289_M_GameofLife();
        sol.gameOfLife(board);
    }
}
