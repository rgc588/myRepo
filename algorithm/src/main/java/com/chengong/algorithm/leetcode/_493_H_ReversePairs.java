package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 3/17/2017.
 */
public class _493_H_ReversePairs {
    int[] copied;
    public int reversePairs(int[] nums) {
        this.copied = new int[nums.length];
        return mergeSort(nums, 0, nums.length-1);
    }

    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end) return 0;
        int mid = start + (end - start)/2;
        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid+1, end);
        for (int i = start, j = mid + 1; i <= mid; i++) {
            while(j <= end && nums[i]/2.0 > nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }
        for (int i = start; i <= end; i++) {
            copied[i] = nums[i];
        }
        int index1 = start;
        int index2 = mid + 1;
        int index = start;
        while(index1 <= mid || index2 <= end) {
            if (index1 > mid || (index2 <= end && copied[index1] >= copied[index2])) {
                nums[index++] = copied[index2++];
            } else {
                nums[index++] = copied[index1++];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] input = new int[] {-5, -5};
        _493_H_ReversePairs sol = new _493_H_ReversePairs();
        System.out.println(sol.reversePairs(input));
    }
}
