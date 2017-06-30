package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/10/2017.
 */
public class _204_E_CountPrimes {
    public int countPrimes(int n) {
        boolean[] mem = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if(!mem[i]) {
                count++;
                for(int j = 2; j*i < n; j++) {
                    mem[i*j] = true;
                }
            }
        }
        return count;
    }
}
