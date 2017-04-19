package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/18/2017.
 */
public class _55_M_JumpGame {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) return false;
            max = Math.max(max, nums[i] + i);
            if (max >= nums.length-1) return true;
        }
        return max >= nums.length-1;
    }
}
