package com.chengong.algorithm.leetcode;

import java.util.*;

/**
 * Created by cheng on 3/20/2017.
 */
public class M491IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> seq = new ArrayList<>();
        helper(-1, 0, nums, seq, rst);
        return rst;
    }

    private void helper(int last, int index, int[] nums, List<Integer> seq, List<List<Integer>> rst) {
        if (seq.size() > 1) {
            List<Integer> newList = new ArrayList<>();
            newList.addAll(seq);
            rst.add(newList);
        }
        Set<Integer> cache = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if((last >= 0 && (nums[last] >= nums[i])) || cache.contains(nums[i])) continue;
            cache.add(nums[i]);
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                    seq.add(nums[j]);
                    helper(j, j+1, nums, seq, rst);
                }
            }
            for (int j = 0; j < count; j++) {
                seq.remove(seq.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] input = new int[] {4,6,7,7};
        M491IncreasingSubsequences sol = new M491IncreasingSubsequences();
        List<List<Integer>> rst = sol.findSubsequences(input);
        System.out.println(rst);
    }
}
