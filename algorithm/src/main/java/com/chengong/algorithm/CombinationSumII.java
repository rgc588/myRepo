package com.chengong.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    private List<List<Integer>> results;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length < 1) {
            return results;
        }

        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(candidates);
        results = new ArrayList<List<Integer>> ();
        combinationSumHelper(path, candidates, target, 0);

        return results;
    }

    private void combinationSumHelper(List<Integer> path, int[] candidates, int sum, int pos) {
        if (sum == 0) {
            results.add(new ArrayList<Integer>(path));
        }

        if (pos >= candidates.length || sum < 0) {
            return;
        }

        int prev = -1;
        for (int i = pos; i < candidates.length; i++) {
            if (candidates[i] != prev) {//if there is duplicate only use the first one
                path.add(candidates[i]);
                combinationSumHelper(path, candidates, sum - candidates[i], i + 1);
                prev = candidates[i];
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {1,2};
        int target = 2;
        List<List<Integer>> rst = new CombinationSumII().combinationSum2(candidates, target);

        System.out.println(rst);
    }
}
