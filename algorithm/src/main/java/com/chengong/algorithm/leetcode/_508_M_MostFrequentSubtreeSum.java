package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cheng on 3/1/2017.
 */
public class _508_M_MostFrequentSubtreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        int maxCount = 0;
        List<Integer> rst = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                rst = new ArrayList<>();
                rst.add(entry.getKey());
                maxCount = entry.getValue();
            } else if (entry.getValue() == maxCount) {
                rst.add(entry.getKey());
            }
        }
        int[] ret = new int[rst.size()];
        for (int i=0; i < rst.size();i++){
            ret[i] = rst.get(i);
        }
        return ret;
    }

    private int helper(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        int left = helper(root.left, map);
        int right = helper(root.right, map);
        int sum = root.val + left + right;
        if (map.containsKey(sum)) {
            map.put(sum, map.get(sum) + 1);
        } else {
            map.put(sum, 1);
        }
        return sum;
    }
}
