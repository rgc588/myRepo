package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/17/2017.
 */
public class _41_H_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        boolean[] mem = new boolean[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0 && nums[i] < nums.length+1) {
                mem[nums[i]] = true;
            }
        }
        for (int i = 1; i < mem.length; i++) {
            if (!mem[i]) return i;
        }
        return nums.length+1;
    }
}
