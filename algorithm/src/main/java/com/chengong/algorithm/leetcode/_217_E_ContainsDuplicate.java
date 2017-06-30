package com.chengong.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cheng on 5/13/2017.
 */
public class _217_E_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int n : nums) {
            if (!s.add(n)) return true;
        }
        return false;
    }
}
