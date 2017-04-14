package com.chengong.algorithm.leetcode;

import java.util.Arrays;

/**
 * Created by cheng on 4/3/2017.
 */
public class _16_M_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);//-3,0,1,2
        int rst = nums[0] + nums[1] + nums[2];//-2
        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];//1--3=4
            int s = i+1;
            int e = nums.length-1;
            while(s<e) {
                if (nums[s] + nums[e] == t) {
                    return target;
                } else {
                    rst = Math.abs(target-rst) > Math.abs(target-nums[s]-nums[e]-nums[i]) ? nums[i] + nums[e] + nums[s] : rst;
                    if (nums[s]+nums[e]<t) {
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
