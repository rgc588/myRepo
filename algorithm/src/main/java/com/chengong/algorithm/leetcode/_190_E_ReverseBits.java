package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/7/2017.
 */
public class _190_E_ReverseBits {
    public int reverseBits(int n) {
        int rst = 0;
        for (int i = 0; i < 32; i++) {
            rst <<= 1;
            rst |= n&1;
            n >>>= 1;
        }
        return rst;
    }
}
