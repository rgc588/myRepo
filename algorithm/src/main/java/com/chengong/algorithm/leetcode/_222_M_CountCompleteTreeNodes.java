package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.TreeNode;

/**
 * Created by cheng on 5/15/2017.
 */
public class _222_M_CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = leftH(root.left);
        int right = leftH(root.right);
        if (left == right) {
            return left+1+countNodes(root.right);
        } else {
            return right+1+countNodes(root.left);
        }
    }

    private int leftH(TreeNode root) {
        if (root == null) return 0;
        return leftH(root.left)*2+1;
    }
}
