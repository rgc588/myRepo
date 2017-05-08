package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/6/2017.
 */
public class _169_E_MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int rst = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) rst = nums[i];
            if (nums[i] == rst) {
                count++;
            } else {
                count--;
            }
        }
        return rst;
    }
}
