package com.chengong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cheng on 4/17/2017.
 */
public class _46_M_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
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
            if (!used[i]) {
                cur.add(nums[i]);
                used[i]=true;
                helper(nums, used, cur, rst);
                used[i]=false;
                cur.remove(cur.size()-1);
            }
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        if (nums == null || nums.length == 0) return rst;
        List<Integer> first = new ArrayList<>();
        first.add(nums[0]);
        rst.add(first);
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> tmp = new ArrayList<>();
            for (int j = 0; j < rst.size(); j++) {
                List<Integer> l = new LinkedList<>(rst.get(j));
                for (int m = 0; m <= l.size(); m++) {
                    l.add(m, nums[i]);
                    tmp.add(new ArrayList<>(l));
                    l.remove(m);
                }
            }
            rst = tmp;
        }
        return rst;
    }
}
