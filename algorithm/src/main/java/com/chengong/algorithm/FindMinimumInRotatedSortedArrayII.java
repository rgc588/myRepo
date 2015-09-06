package com.chengong.algorithm;

public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while(end - start >= 2) {
            int mid = start + (end - start)/2;
            while(nums[start] == nums[mid] && start < mid) {
                start++;
            }
            while(nums[end] == nums[start] && end > mid) {
                end--;
            }

            if(nums[mid] > nums[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return nums[start] < nums[end] ? nums[start] : nums[end];
    }

    public static void main(String[] args) {
        int[] nums = {3,1,3};

        System.out.println(new FindMinimumInRotatedSortedArrayII().findMin(nums));
    }
}
