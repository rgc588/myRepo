package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/20/2017.
 */
public class _79_M_WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (search(board, i, j, w, 0)) return true;
            }
        }
        return false;
    }

    private boolean search(char[][] board, int i, int j, char[] word, int n) {
        if (n >= word.length) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) return false;
        if (word[n] != board[i][j]) return false;
        board[i][j] ^= 256; //prevent circle
        boolean found = search(board, i+1, j, word, n+1) || search(board, i, j+1, word, n+1) ||search(board, i-1, j, word, n+1) ||search(board, i, j-1, word, n+1);
        board[i][j] ^= 256;
        return found;
    }
}
