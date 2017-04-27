package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.TreeNode;

/**
 * Created by cheng on 4/26/2017.
 */
public class _124_H_BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        return helper(root)[0];
    }

    private int[] helper(TreeNode root) {
        int val = root.val;
        if (root.left != null && root.right != null) {
            int[] left = helper(root.left);
            int[] right = helper(root.right);
            int max0 = Math.max(left[0], right[0]);
            int max1 = Math.max(left[1], right[1]);
            max1 = Math.max(0, max1);
            max1 = max1+val;
            max0 = Math.max(max1, val+left[1]+right[1]);
            max0 = Math.max(Math.max(left[0],right[0]), max0);
            return new int[] {max0, max1};
        } else if (root.left != null) {
            int[] left = helper(root.left);
            int max1 = Math.max(val, val+left[1]);
            return new int[] {Math.max(left[0], max1), max1};
        } else if (root.right != null) {
            int[] right = helper(root.right);
            int max1 = Math.max(val, val+right[1]);
            return new int[] {Math.max(right[0], max1), max1};
        }
        return new int[] {val, val};
    }
}
