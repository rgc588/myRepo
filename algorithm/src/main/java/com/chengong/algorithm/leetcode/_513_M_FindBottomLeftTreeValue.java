package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.TreeNode;

/**
 * Created by cheng on 2/28/2017.
 */
public class _513_M_FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        int[] mem = new int[2];
        mem[1] = -1;
        helper(root, mem, 0);
        return mem[0];
    }

    private void helper(TreeNode root, int[] mem, int current_level) {
        if (root == null) return;
        if (root.left == null && root.right == null && current_level > mem[1]) {
            mem[0] = root.val;
            mem[1] = current_level;
            return;
        }
        helper(root.left, mem, current_level+1);
        helper(root.right, mem, current_level+1);
    }
}
