package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/7/2017.
 */
public class _191_E_Numberof1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            count += n&1;
            n >>>= 1;
        }
        return count;
    }
}
