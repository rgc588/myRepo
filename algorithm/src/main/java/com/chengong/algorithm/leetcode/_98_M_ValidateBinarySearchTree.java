package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.TreeNode;

/**
 * Created by cheng on 4/24/2017.
 */
public class _98_M_ValidateBinarySearchTree {
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }

    private boolean helper(TreeNode root) {
        if (root == null) return true;
        if (!helper(root.left)) return false;
        if (pre != null && root.val <= pre.val) return false;
        pre = root;
        return helper(root.right);
    }
}
