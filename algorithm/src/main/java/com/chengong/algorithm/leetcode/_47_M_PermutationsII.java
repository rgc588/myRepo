package com.chengong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cheng on 4/17/2017.
 */
public class _47_M_PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        helper(nums, used, cur, rst);
        return rst;
    }

    private void helper(int[] nums, boolean[] used, List<Integer> cur, List<List<Integer>> rst) {
        if (cur.size() == nums.length) {
            List<Integer> tmp = new ArrayList<>(cur);
            rst.add(tmp);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            cur.add(nums[i]);
            used[i]=true;
            helper(nums, used, cur, rst);
            used[i]=false;
            cur.remove(cur.size()-1);
        }
    }
}
