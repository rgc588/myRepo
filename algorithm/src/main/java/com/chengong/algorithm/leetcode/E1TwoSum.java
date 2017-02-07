package com.chengong.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by cheng on 2/6/2017.
 */
public class E1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (dict.containsKey(key)) {
                return new int[] {dict.get(key), i};
            } else {
                dict.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
