package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/17/2017.
 */
public class _26_E_RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        while(j < nums.length) {
            if (j == 0 || nums[j] != nums[j-1]) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }
}
