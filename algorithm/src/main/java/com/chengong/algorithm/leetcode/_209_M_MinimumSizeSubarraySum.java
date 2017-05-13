package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/11/2017.
 */
public class _209_M_MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        int min = 0;
        int i = 0;
        int j = 0;
        while(j < nums.length) {
            while(sum < s && j < nums.length) {
                sum += nums[j++];
            }
            while(sum >= s && i < j) {
                min = min == 0 ? j-i : Math.min(min, j-i);
                sum -= nums[i++];
            }
            if (min <= 1) return min;
        }
        return min;
    }
}
