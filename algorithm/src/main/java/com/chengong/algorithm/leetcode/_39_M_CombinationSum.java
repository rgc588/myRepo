package com.chengong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cheng on 3/31/2017.
 */
public class _39_M_CombinationSum {
    List<List<Integer>> rst = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, current);
        return rst;
    }

    private synchronized void helper(int[] c, int index, int target, List<Integer> current) {
        if (target == 0) {
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(current);
            rst.add(tmp);
            return;
        }
        if (index >= c.length) return;
        if (c[index] > target) return;
        helper(c, index+1, target, current);
        int count = 0;
        while(target > 0) {
            count++;
            current.add(c[index]);
            target = target - c[index];
            helper(c, index+1, target, current);
        }
        for (int i = 0; i < count; i++) {
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] test_input = new int[] {2,3,6,7};
        _39_M_CombinationSum sol = new _39_M_CombinationSum();
        int target = 7;
        List<List<Integer>> rst = sol.combinationSum(test_input, target);
        System.out.print(rst);
    }
}
