package com.chengong.algorithm.leetcode;


/**
 * Created by cheng on 7/14/2017.
 */
public class _31_M_NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int i = nums.length-2;
        while(i>=0 && nums[i] >= nums[i+1]) i--;
        int start = i+1;
        if (i >= 0) {
            int j = i;
            int n = nums[i];
            while(j+1 < nums.length && nums[j+1] > n) j++;
            nums[i] = nums[j];
            nums[j] = n;
        }
        int end = nums.length-1;
        while(start<end) {
            swap(start++, end--, nums);
        }
    }

    public void nextPermutation2(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int i = nums.length-2;
        while(i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        if (i >= 0) {
            int start = i+1;
            int end = nums.length-1;
            while(start < end) {
                int mid = (start+end+1)/2;
                if (nums[mid] > nums[i]) {
                    start = mid;
                } else {
                    end = mid-1;
                }
            }
            swap(i,start,nums);
        }
        i++;
        int j = nums.length-1;
        while(i<j) {
            swap2(i,j,nums);
            i++;
            j--;
        }
    }

    private void swap2(int i, int j, int[] nums) {
        nums[i] = nums[i]^nums[j];
        nums[j] = nums[i]^nums[j];
        nums[i] = nums[i]^nums[j];
    }

    private void swap(int i, int j, int[]nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] input = new int[] {2,3,1};
        _31_M_NextPermutation sol = new _31_M_NextPermutation();
        sol.nextPermutation2(input);
    }
}
