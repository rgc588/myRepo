package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.TreeNode;

/**
 * Created by cheng on 4/26/2017.
 */
public class _129_M_SumRoottoLeafNumbers {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return sum;
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int num) {
        int val = num*10+root.val;
        if (root.left == null && root.right == null) {
            sum += val;
            return;
        }
        if (root.left != null) helper(root.left, val);
        if (root.right != null) helper(root.right, val);
    }
}
