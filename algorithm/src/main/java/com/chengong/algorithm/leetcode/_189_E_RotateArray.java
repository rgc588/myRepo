package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/7/2017.
 */
public class _189_E_RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums == null || k == 0) return;
        int n = nums.length;
        k = k%n;
        if (k == 0) return;
        if (k < 0) k = n-k;
        helper(nums, 0, n-k-1);
        helper(nums, n-k, n-1);
        helper(nums, 0, n-1);
    }

    private void helper(int[] nums, int i, int j) {
        while(i < j) {
            nums[i] = nums[i]^nums[j];
            nums[j] = nums[i]^nums[j];
            nums[i] = nums[i]^nums[j];
            i++;
            j--;
        }
    }
}
