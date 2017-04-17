package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/17/2017.
 */
public class _27_E_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        while(j < nums.length) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }
}
