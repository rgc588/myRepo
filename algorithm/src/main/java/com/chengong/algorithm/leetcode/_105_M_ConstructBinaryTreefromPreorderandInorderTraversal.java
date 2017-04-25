package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.TreeNode;

/**
 * Created by cheng on 4/24/2017.
 */
public class _105_M_ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, inorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] pre, int index, int[] in, int left, int right) {
        if (index >= pre.length || left > right) return null;
        int val = pre[index];
        TreeNode root = new TreeNode(val);
        int i = left;
        for (; i <= right; i++) {
            if (in[i] == val) break;
        }
        root.left = helper(pre, index+1, in, left, i-1);
        root.right = helper(pre, index+i-left+1, in, i+1, right);
        return root;
    }
}
