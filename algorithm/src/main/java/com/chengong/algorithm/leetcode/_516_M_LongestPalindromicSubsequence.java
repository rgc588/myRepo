package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 2/27/2017.
 */
public class _516_M_LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        Integer[][] mem = new Integer[s.length()][s.length()];
        return helper(s, 0, s.length()-1, mem);
    }

    private int helper(String s, int i, int j, Integer[][] mem) {
        if (mem[i][j] != null) return mem[i][j];
        if (i > j) return 0;
        if (i == j) return 1;
        Integer max;
        if (s.charAt(i) == s.charAt(j)) {
            max = helper(s, i+1, j-1, mem) + 2;
        } else {
            max = Math.max(helper(s, i+1, j, mem), helper(s, i, j-1, mem));
        }
        mem[i][j] = max;
        return max;
    }
    /**
     public int longestPalindromeSubseq(String s) {
     int[] mem = new int[s.length()];
     for (int i = 0; i < s.length(); i++) {
     int[] tmp = new int[s.length()];
     tmp[i] = 1;
     for (int j = i-1; j >= 0; j--) {
     if (s.charAt(i) == s.charAt(j)) {
     tmp[j] = mem[j+1] + 2;
     } else {
     tmp[j] = Math.max(tmp[j+1], mem[j]);
     }
     }
     mem = tmp;
     }
     return mem[0];
     }
     */
}
