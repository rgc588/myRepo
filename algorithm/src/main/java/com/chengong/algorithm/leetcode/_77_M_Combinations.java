package com.chengong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 4/20/2017.
 */
public class _77_M_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        boolean[] used = new boolean[n+1];
        if (k > n) k = n;
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(rst, cur, used, 1, k);
        return rst;
    }

    private void helper(List<List<Integer>> rst, List<Integer> cur, boolean[] used, int n, int k) {
        if (cur.size() == k) {
            List<Integer> tmp = new ArrayList<>(cur);
            rst.add(tmp);
            return;
        }
        for (int i = n; i < used.length; i++) {
            if (!used[i]) {
                used[i]=true;
                cur.add(i);
                helper(rst, cur, used, i+1, k);
                cur.remove(cur.size()-1);
                used[i]=false;
            }
        }
    }
}
