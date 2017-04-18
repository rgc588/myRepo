package com.chengong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cheng on 3/31/2017.
 */
public class _39_M_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, candidates, target, c, rst);
        return rst;
    }

    private void helper(int index, int[] n, int t, List<Integer> c, List<List<Integer>> rst) {
        if (t < 0) return;
        if (t == 0) {
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(c);
            rst.add(tmp);
        }
        for (int i = index; i < n.length; i++) {
            c.add(n[i]);
            helper(i, n, t-n[i], c, rst);
            c.remove(c.size()-1);
        }
    }
}
