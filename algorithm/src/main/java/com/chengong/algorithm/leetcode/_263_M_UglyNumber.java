package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/21/2017.
 */
public class _263_M_UglyNumber {
    public boolean isUgly(int num) {
        int[] factors = new int[] {2,3,5};
        for (int f : factors) {
            while(num > 1 && num%f == 0) {
                num /= f;
            }
        }
        return num == 1;
    }
}
