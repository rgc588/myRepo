package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/17/2017.
 */
public class _33_M_SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length-1;
        while(i<=j) {
            int m = i + (j-i)/2;
            if (nums[m] == target) return m;
            if (nums[m] < nums[j]) {
                if (nums[m] < target && target <= nums[j]) {
                    i = m+1;
                } else {
                    j = m-1;
                }
            } else {
                if (nums[m] > target && target >= nums[i]) {
                    j = m-1;
                } else {
                    i = m+1;
                }
            }
        }
        return -1;
    }
}
