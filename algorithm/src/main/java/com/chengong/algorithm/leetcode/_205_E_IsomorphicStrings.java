package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/10/2017.
 */
public class _205_E_IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        int[] mem1 = new int[256];
        int[] mem2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (mem1[s.charAt(i)] != mem2[t.charAt(i)]) return false;
            mem1[s.charAt(i)] = i+1;
            mem2[t.charAt(i)] = i+1;
        }
        return true;
    }
}