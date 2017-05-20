package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/18/2017.
 */
public class _238_M_ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null) return null;
        int[] rst = new int[nums.length];
        int m = 1;
        for (int i = 0; i < nums.length; i++) {
            rst[i] = m;
            m = nums[i]*m;
        }
        m = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            rst[i] = rst[i]*m;
            m = m*nums[i];
        }
        return rst;
    }
}
