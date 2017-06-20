package com.chengong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 6/12/2017.
 */
public class _425_H_WordSquares {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> rst = new ArrayList<>();
        if (words == null || words.length == 0) return rst;
        List<String> cur = new ArrayList<>();
        for (int i = 0; i < words[0].length(); i++) {
            cur.add("");
        }
        helper(cur, 0, words, rst);
        return rst;
    }

    private void helper(List<String> cur, int i, String[] words, List<List<String>> rst) {
        if (i == words[0].length()) {
            List<String> tmp = new ArrayList<>();
            tmp.addAll(cur);
            rst.add(tmp);
            return;
        }
        for (int m = 0; m < words.length; m++) {
            if (cur.get(i).isEmpty() || words[m].startsWith(cur.get(i))) {
                cur.set(i, words[m]);
                for (int n = i+1; n < words[m].length(); n++) {
                    cur.set(n, cur.get(n)+words[m].charAt(n));
                }
                helper(cur, i+1, words, rst);
                for (int n = i+1; n < words[m].length(); n++) {
                    cur.set(n, cur.get(n).substring(0, i));
                }
                cur.set(i, cur.get(i).substring(0, i));
            }
        }
    }

    public static void main(String[] args) {
        String[] input = new String[] {"area","lead","wall","lady","ball"};
        _425_H_WordSquares sol = new _425_H_WordSquares();
        List<List<String>> rst = sol.wordSquares(input);
        System.out.print(rst);
    }
}
