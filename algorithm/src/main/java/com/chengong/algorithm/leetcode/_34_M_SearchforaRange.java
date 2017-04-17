package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/17/2017.
 */
public class _34_M_SearchforaRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[] {-1,-1};
        int i = 0;
        int j = nums.length-1;
        while(i < j) {
            int m = i + (j-i)/2;
            if (nums[m] >= target) {
                j = m;
            } else {
                i = m+1;
            }
        }
        if (nums[i] != target) return new int[] {-1,-1};
        int[] rst = new int[] {i, -1};
        j = nums.length-1;
        while(i < j) {
            int m = i + (j-i+1)/2;
            if (nums[m] <= target) {
                i = m;
            } else {
                j = m-1;
            }
        }
        rst[1] = i;
        return rst;
    }
}
