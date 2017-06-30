package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/7/2017.
 */
public class _198_E_HouseRobber {
    public int rob(int[] nums) {
        int rob = 0;
        int nrob = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = nrob + nums[i];
            nrob = Math.max(rob,nrob);
            rob = tmp;
        }
        return Math.max(rob,nrob);
    }
}
