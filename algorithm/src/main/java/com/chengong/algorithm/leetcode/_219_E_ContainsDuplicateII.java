package com.chengong.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cheng on 5/13/2017.
 */
public class _219_E_ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= k && i < nums.length; i++) {
            if (!set.add(nums[i])) return true;
        }
        for (int i = k+1; i < nums.length; i++) {
            set.remove(nums[i-k-1]);
            if (!set.add(nums[i])) return true;
        }
        return false;
    }
}
