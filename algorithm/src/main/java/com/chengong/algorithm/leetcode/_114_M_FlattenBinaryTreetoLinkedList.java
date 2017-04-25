package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.TreeNode;

/**
 * Created by cheng on 4/24/2017.
 */
public class _114_M_FlattenBinaryTreetoLinkedList {
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        pre = root;
        flatten(root.right);
        if(pre != null) pre.right = tmp;
        flatten(tmp);
    }
}
