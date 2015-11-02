package com.chengong.algorithm;

/**
 * Created by chengong on 9/22/15.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int iP = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                continue;
            } else {
                switchArray(nums, iP, i);
                iP++;
            }
        }
    }

    private void switchArray(int[] nums, int x, int y) {
        if(x != y) {
            nums[x] = nums[x]^nums[y];
            nums[y] = nums[x]^nums[y];
            nums[x] = nums[x]^nums[y];
        }
    }
}
