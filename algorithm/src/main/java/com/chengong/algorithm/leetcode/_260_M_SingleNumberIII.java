package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/21/2017.
 */
public class _260_M_SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int rst = 0;
        for (int n : nums) {
            rst ^= n;
        }
        int dd = 1;
        int tmp = rst;
        while((tmp&dd) == 0) {
            dd <<= 1;
        }
        boolean[] c = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            c[i] = (nums[i]&dd) == 0;
        }
        int rst1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (c[i]) rst1 ^= nums[i];
        }
        return new int[] {rst1, rst^rst1};
    }
}
