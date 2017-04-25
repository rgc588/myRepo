package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.TreeNode;

/**
 * Created by cheng on 4/24/2017.
 */
public class _110_E_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return helper(root) >= 0;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        if (left == -1) return -1;
        int right = helper(root.right);
        if (right == -1) return -1;
        int diff = Math.abs(left-right);
        return diff > 1 ? -1 : Math.max(left, right)+1;
    }
}
