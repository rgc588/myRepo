package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.TreeNode;

/**
 * Created by cheng on 4/24/2017.
 */
public class _111_E_MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return helper(root);
    }

    private int helper(TreeNode root) {
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return minDepth(root.right)+1;
        if (root.right == null) return minDepth(root.left)+1;
        return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }
}
