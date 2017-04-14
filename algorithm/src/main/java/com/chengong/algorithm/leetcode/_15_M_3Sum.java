package com.chengong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cheng on 4/3/2017.
 */
public class _15_M_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        if (nums == null || nums.length == 0) return rst;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                int target = 0 - nums[i];
                int s = i + 1;
                int e = nums.length - 1;
                while(s < e) {
                    if (nums[s] + nums[e] == target) {
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[s]);
                        l.add(nums[e]);
                        rst.add(l);
                        int v1 = nums[s];
                        while(s < nums.length && nums[s] == v1) {
                            s++;
                        }
                        int v2 = nums[e];
                        while(e >= 0 && nums[e] == v2) {
                            e--;
                        }
                    } else if (nums[s] + nums[e] < target) {
                        s++;
                    } else {
                        e--;
                    }
                }
            }
        }
        return rst;
    }
}
