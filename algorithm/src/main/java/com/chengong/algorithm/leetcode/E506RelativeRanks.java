package com.chengong.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cheng on 3/1/2017.
 */
public class E506RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        Arrays.sort(nums);
        int index = 0;
        String[] rst = new String[nums.length];
            for (int i = nums.length-1; i >= 0; i--) {
            if (index == 0) {
                rst[map.get(nums[i])] = "Gold Medal";
            } else if (index == 1) {
                rst[map.get(nums[i])] = "Silver Medal";
            } else if (index == 2) {
                rst[map.get(nums[i])] = "Bronze Medal";
            } else {
                rst[map.get(nums[i])] = String.valueOf(index+1);
            }
            index++;
        }
        return rst;
    }
}
