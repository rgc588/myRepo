package com.chengong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cheng on 4/21/2017.
 */
public class _90_M_SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, nums, cur, rst);
        return rst;
    }

    private void helper(int index, int[] nums, List<Integer> cur, List<List<Integer>> rst) {
        if (index > nums.length) return;
        if (index <= nums.length) {
            List<Integer> tmp = new ArrayList<>(cur);
            rst.add(tmp);
        }
        if (index == nums.length) return;
        for (int i = index; i < nums.length; i++) {
            cur.add(nums[i]);
            helper(i+1, nums, cur, rst);
            cur.remove(cur.size()-1);
            while(i+1 < nums.length && nums[i+1] == nums[i]) {
                i++;
            }
        }
    }
}
