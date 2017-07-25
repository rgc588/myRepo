package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/17/2017.
 */
public class _41_H_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        boolean[] mem = new boolean[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0 && nums[i] < nums.length+1) {
                mem[nums[i]] = true;
            }
        }
        for (int i = 1; i < mem.length; i++) {
            if (!mem[i]) return i;
        }
        return nums.length+1;
    }

    public int firstMissingPositive2(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i]-1]) {
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j+1) return j+1;
        }
        return nums.length+1;
    }

    public static void main(String[] args) {
        int[] input = new int[] {0,1,2};
        _41_H_FirstMissingPositive sol = new _41_H_FirstMissingPositive();
        System.out.println(sol.firstMissingPositive2(input));
    }
}
