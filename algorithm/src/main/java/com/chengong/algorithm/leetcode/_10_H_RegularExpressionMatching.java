package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 6/20/2017.
 */
public class _10_H_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] mem = new boolean[s.length()+1][p.length()+1];
        mem[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') mem[0][i+1] = mem[0][i-1];
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
                    mem[i+1][j+1] = mem[i][j];
                } else if (p.charAt(j) == '*') {
                    mem[i+1][j+1] = mem[i+1][j-1];
                    if (p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i)) mem[i+1][j+1] = mem[i+1][j+1] || mem[i+1][j] || mem[i][j+1];
                }
            }
        }
        return mem[s.length()][p.length()];
    }

    public boolean isMatch2(String s, String p) {
        return helper(s, 0, p, 0);
    }

    private boolean helper(String s, int is, String p, int ip) {
        if (ip == p.length() && is == s.length()) return true;
        if (ip == p.length()) return false;
        if (ip+1 < p.length() && p.charAt(ip+1) == '*') {
            return helper(s, is, p, ip+2) || (is < s.length() && (p.charAt(ip) == '.' || s.charAt(is) == p.charAt(ip)) && helper(s, is+1, p, ip));
        } else {
            return is < s.length() && (p.charAt(ip) == '.' || s.charAt(is) == p.charAt(ip)) && helper(s, is+1, p, ip+1);
        }
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        _10_H_RegularExpressionMatching sol = new _10_H_RegularExpressionMatching();
        System.out.print(sol.isMatch(s, p));
    }
}
