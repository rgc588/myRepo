package com.chengong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 4/20/2017.
 */
public class _78_M_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        rst.add(first);
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> newAdd = new ArrayList<>();
            for (List<Integer> each : rst) {
                List<Integer> tmp = new ArrayList<>();
                tmp.addAll(each);
                tmp.add(nums[i]);
                newAdd.add(tmp);
            }
            rst.addAll(newAdd);
        }
        return rst;
    }
}
