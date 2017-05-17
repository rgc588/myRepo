package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/13/2017.
 */
public class _215_M_KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        int i = 0;
        int j = nums.length-1;
        k = k-1;
        while(i < j) {
            int p = helper(nums, i, j);
            if (p == k) {
                return nums[k];
            } else if (p < k) {
                i = p+1;
            } else {
                j = p-1;
            }
        }
        return nums[k];
    }

    private int helper(int[] nums, int i, int j) {
        int p = i;
        j=j+1;
        i=i+1;
        while(i < j) {
            if (nums[i] < nums[p]) {
                swap(nums, i ,--j);
            } else {
                i++;
            }
        }
        swap(nums, p, i-1);
        return i-1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-1,2,0};
        int k = 2;
        _215_M_KthLargestElementinanArray sol = new _215_M_KthLargestElementinanArray();
        sol.findKthLargest(nums, k);
    }
}
