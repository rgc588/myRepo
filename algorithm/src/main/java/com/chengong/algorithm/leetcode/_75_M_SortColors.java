package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/20/2017.
 */
public class _75_M_SortColors {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int cur = 0;
        while(cur <= end) {
            if (nums[cur] == 0) {
                swap(nums, cur, start++);
                cur++;
            } else if (nums[cur] == 2) {
                swap(nums, cur, end--);
            } else {
                cur++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] = nums[i]^nums[j];
            nums[j] = nums[i]^nums[j];
            nums[i] = nums[i]^nums[j];
        }
    }
}
