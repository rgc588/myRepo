package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 7/11/2017.
 */
public class _72_H_EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1.length() < word2.length()) {
            String tmp = word1;
            word1 = word2;
            word2 = tmp;
        }
        int m = word1.length();
        int n = word2.length();
        int[] mem = new int[n+1];
        for (int i = 1; i <= m; i++) {
            int[] tmp = new int[n+1];
            tmp[0] = mem[0]+1;
            for (int j = 1; j <= i && j <= n; j++) {
                tmp[j] = mem[j-1] + (word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1);
                if (j != i) tmp[j] = Math.min(tmp[j], mem[j])+1;
            }
            mem = tmp;
        }
        return mem[n];
    }

    public static void main(String[] args) {
        _72_H_EditDistance sol = new _72_H_EditDistance();
        System.out.print(sol.minDistance("a", "ab"));
    }
}
