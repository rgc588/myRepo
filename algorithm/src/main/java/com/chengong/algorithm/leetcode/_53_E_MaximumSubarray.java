package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/18/2017.
 */
public class _53_E_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] mem = new int[nums.length];
        mem[0] = nums[0];
        int max = mem[0];
        for (int i = 1; i < mem.length; i++) {
            mem[i] = Math.max(nums[i], mem[i-1]+nums[i]);
            if (mem[i] > max) max = mem[i];
        }
        return max;
    }
}
