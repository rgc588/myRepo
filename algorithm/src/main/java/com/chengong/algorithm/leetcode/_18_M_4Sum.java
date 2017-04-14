package com.chengong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cheng on 4/13/2017.
 */
public class _18_M_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rst = new ArrayList<>();
        if (nums == null || nums.length < 4) return rst;
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length) {
            int j = i+1;
            while (j < nums.length) {
                int m = j+1;
                int n = nums.length-1;
                int t = target - nums[i] - nums[j];
                while(m<n) {
                    if (nums[m]+nums[n] == t) {
                        rst.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[m],nums[n])));
                        while(m+1 < nums.length && nums[m]==nums[m+1]) {
                            m++;
                        }
                        while(n+1 < nums.length && nums[n]==nums[n+1]) {
                            n++;
                        }
                        m++;
                        n--;
                    } else if (nums[m]+nums[n] < t) {
                        m++;
                    } else {
                        n--;
                    }
                }
                while(j+1 < nums.length && nums[j]==nums[j+1]) {
                    j++;
                }
                j++;
            }
            while(i+1 < nums.length && nums[i]==nums[i+1]) {
                i++;
            }
            i++;
        }
        return rst;
    }
}
