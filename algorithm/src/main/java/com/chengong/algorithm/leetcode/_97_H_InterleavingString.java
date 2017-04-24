package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/24/2017.
 */
public class _97_H_InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int l = s3.length();
        if (l == 0) return true;
        if (m == 0) return s2.equals(s3);
        if (n == 0) return s1.equals(s3);
        if (m+n!=l)return false;
        boolean[][] mem = new boolean[m+1][n+1];
        for (int i = 1; i < m+1; i++) {
            if (s1.charAt(i-1) == s3.charAt(i-1)) {
                mem[i][0] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i < n+1; i++) {
            if (s2.charAt(i-1) == s3.charAt(i-1)) {
                mem[0][i] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if ((s1.charAt(i-1) == s3.charAt(i+j-1) && mem[i-1][j]) || (s2.charAt(j-1) == s3.charAt(i+j-1) && mem[i][j-1])) {
                    mem[i][j] = true;
                }
            }
        }
        return mem[m][n];
    }
}
