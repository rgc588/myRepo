package com.chengong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 5/13/2017.
 */
public class _216_M_CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(1, k, rst, cur, n);
        return rst;
    }

    private void helper(int s, int k, List<List<Integer>> rst, List<Integer> cur, int n) {
        if (cur.size() == k) {
            if (n == 0) {
                List<Integer> tmp = new ArrayList<>();
                tmp.addAll(cur);
                rst.add(tmp);
            }
            return;
        }
        for (int i = s; i <= 9; i++) {
            cur.add(i);
            helper(i+1, k, rst, cur, n-i);
            cur.remove(cur.size()-1);
        }
    }
}
