package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/8/2017.
 */
public class _201_M_BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        int moved = 1;
        while(m != n) {
            m >>>= 1;
            n >>>= 1;
            moved <<= 1;
        }
        return m*moved;
    }
}
