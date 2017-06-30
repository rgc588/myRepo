package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.TreeNode;

/**
 * Created by cheng on 5/18/2017.
 */
public class _236_M_LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root  == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }
}
