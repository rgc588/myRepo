package com.chengong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cheng on 4/17/2017.
 */
public class _40_M_CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, cur, target, candidates, rst);
        return rst;
    }

    private void helper(int index, List<Integer> cur, int target, int[] nums, List<List<Integer>> rst) {
        if (target < 0) return;
        if (target == 0) {
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(cur);
            rst.add(tmp);
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i-1] == nums[i]) continue;
            cur.add(nums[i]);
            helper(i+1, cur, target-nums[i], nums, rst);
            cur.remove(cur.size()-1);
        }
    }
}
