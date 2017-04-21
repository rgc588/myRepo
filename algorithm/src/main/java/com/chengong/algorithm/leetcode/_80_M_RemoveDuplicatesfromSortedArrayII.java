package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/20/2017.
 */
public class _80_M_RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int index = 0;
        int cur = 0;
        while(cur < nums.length) {
            if (count == 0) {
                nums[index++] = nums[cur];
                count++;
            } else {
                if (nums[cur] != nums[cur-1]) {
                    nums[index++] = nums[cur];
                    count = 1;
                } else {
                    if (count < 2) {
                        nums[index++] = nums[cur];
                    }
                    count++;
                }
            }
            cur++;
        }
        return index;
    }
}
