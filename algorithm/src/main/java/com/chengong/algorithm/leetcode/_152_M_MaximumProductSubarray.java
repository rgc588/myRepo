package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/3/2017.
 */
public class _152_M_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        int rst = max[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(nums[i], max[i-1]*nums[i]);
            max[i] = Math.max(max[i], min[i-1]*nums[i]);
            min[i] = Math.min(nums[i], min[i-1]*nums[i]);
            min[i] = Math.min(min[i], max[i-1]*nums[i]);
            rst = Math.max(max[i], rst);
        }
        return rst;
    }
}
