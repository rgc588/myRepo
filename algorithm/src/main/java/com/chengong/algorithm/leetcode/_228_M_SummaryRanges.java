package com.chengong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 5/16/2017.
 */
public class _228_M_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> rst = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int s = i;
            while(i+1 < nums.length && nums[i+1] - nums[i] == 1) {
                i++;
            }
            if (i == s) {
                rst.add(String.valueOf(nums[i]));
            } else {
                rst.add(nums[s]+"->"+nums[i]);
            }
        }
        return rst;
    }
}
