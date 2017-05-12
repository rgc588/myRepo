package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/3/2017.
 */
public class _153_M_FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int s = 0;
        int e = nums.length-1;
        while(s < e) {
            int mid = s + (e - s + 1)/2;
            if (nums[mid] < nums[mid-1]) {
                return nums[mid];
            } else if (nums[mid] > nums[e]) {
                s = mid+1;
            } else {
                e = mid-1;
            }
        }
        return nums[s];
    }
}
