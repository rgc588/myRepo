package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.TreeNode;

/**
 * Created by cheng on 4/3/2017.
 */
public class E543DiameterofBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root)[1];
    }

    private int[] helper(TreeNode root) {
        if (root == null) return new int[] {0,0};
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int dia = Math.max(Math.max(left[0]+right[0],left[1]),right[1]);
        return new int[] {Math.max(left[0], right[0])+1, dia};
    }
}
