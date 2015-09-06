package com.chengong.algorithm;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> rst = new ArrayList<String>();

        for(String word : words) {
            boolean found = false;
            for(int i = 0; i < board.length; i++) {
                if(found) break;
                for(int j = 0; j < board[0].length; j++) {
                    if(found) break;
                    if(find(board, i, j, word, 0)) {
                        rst.add(word);
                        found = true;
                        break;
                    }
                }
            }
        }
        return rst;
    }

    private boolean find(char[][] board, int i, int j, String word, int start) {
        if(start == word.length()) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#') return false;

        if(board[i][j] == word.charAt(start)) {
            board[i][j] = '#';
            boolean b = find(board, i, j - 1, word, start + 1) || find(board, i, j + 1, word, start + 1) || find(board, i + 1, j, word, start + 1) || find(board, i - 1, j, word, start + 1);
            board[i][j] = word.charAt(start);
            return b;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'a','b'},
                {'c', 'd'}};

        String[] words = {"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};

        List<String> rst = new WordSearchII().findWords(board, words);

        System.out.print(rst);
    }
}
