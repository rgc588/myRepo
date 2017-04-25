package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.TreeNode;

/**
 * Created by cheng on 4/24/2017.
 */
public class _112_E_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return helper(root, sum);
    }

    private boolean helper(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        boolean left = false;
        boolean right = false;
        if (root.right != null) right = helper(root.right, sum - root.val);
        if (root.left != null) left = helper(root.left, sum - root.val);
        return left || right;
    }
}
