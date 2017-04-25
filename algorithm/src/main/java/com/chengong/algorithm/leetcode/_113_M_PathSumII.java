package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 4/24/2017.
 */
public class _113_M_PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(root, sum, cur, rst);
        return rst;
    }

    private void helper(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> rst) {
        if (root == null) return;
        cur.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> tmp = new ArrayList<>(cur);
            rst.add(tmp);
        }
        helper(root.left, sum-root.val, cur, rst);
        helper(root.right, sum-root.val, cur, rst);
        cur.remove(cur.size()-1);
    }
}
