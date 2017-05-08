package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/4/2017.
 */
public class _167_E_TwoSumIIInputarrayissorted {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0) return null;
        int i = 0;
        int j = numbers.length-1;
        while(i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[] {i+1,j+1};
            }
            if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }
}
