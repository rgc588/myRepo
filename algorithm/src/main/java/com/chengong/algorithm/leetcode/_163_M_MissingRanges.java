package com.chengong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 7/19/2017.
 */
public class _163_M_MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        long start = lower;
        List<String> rst = new ArrayList<>();
        for (int n : nums) {
            if (n >= lower && n <= upper) {
                long end = n-1;
                if (start == end) {
                    rst.add(String.valueOf(start));
                } else if (start < end) {
                    rst.add(start+"->"+end);
                }
                start = (long)n+1;
            }
        }
        if (start == upper) {
            rst.add(String.valueOf(start));
        } else if (start < upper) {
            rst.add(start + "->" + upper);
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] input = new int[] {Integer.MAX_VALUE};
        int lower = 0;
        int upper = Integer.MAX_VALUE;
        _163_M_MissingRanges sol = new _163_M_MissingRanges();
        sol.findMissingRanges(input, lower, upper);
    }
}
