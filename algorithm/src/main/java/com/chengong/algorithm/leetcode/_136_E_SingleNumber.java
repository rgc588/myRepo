package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/28/2017.
 */
public class _136_E_SingleNumber {
    public int singleNumber(int[] nums) {
        int rst = 0;
        for (int i = 0; i < nums.length; i++) {
            rst ^= nums[i];
        }
        return rst;
    }
}
