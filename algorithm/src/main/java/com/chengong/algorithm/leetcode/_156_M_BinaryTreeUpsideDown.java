package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.TreeNode;

/**
 * Created by cheng on 5/28/2017.
 */
public class _156_M_BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode left = null;
        TreeNode right = null;
        while(cur != null) {
            TreeNode curLeft = cur.left;
            TreeNode curRight = cur.right;
            cur.left = left;
            cur.right = right;
            left = curRight;
            right = cur;
            cur = curLeft;
        }
        return right;
    }
}
