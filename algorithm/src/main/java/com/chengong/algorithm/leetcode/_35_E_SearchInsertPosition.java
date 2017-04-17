package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/17/2017.
 */
public class _35_E_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length-1;
        while(i < j) {
            int m = i + (j-i)/2;
            if (nums[m] == target) return m;
            if (nums[m] < target) {
                i = m+1;
            } else {
                j = m;
            }
        }
        if (nums[i] >= target) return i;
        return i+1;
    }
}
