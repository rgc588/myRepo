package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/6/2017.
 */
public class _172_E_FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int rst = 0;
        long m = 5;//overflow
        while(m <= n) {
            rst += n/m;
            m*=5;
        }
        return rst;
    }
}
