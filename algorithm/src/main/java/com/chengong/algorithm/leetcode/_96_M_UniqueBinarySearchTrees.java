package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/24/2017.
 */
public class _96_M_UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int[] mem = new int[n+1];
        mem[0] = 1;
        mem[1] = 1;
        for (int i = 2; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                count += mem[j]*mem[i-1-j];
            }
            mem[i] = count;
        }
        return mem[n];
    }
}
