package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.TreeNode;

/**
 * Created by cheng on 4/24/2017.
 */
public class _108_E_ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    private TreeNode helper(int[] nums, int i, int j) {
        if (i > j) return null;
        int mid = i + (j-i)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, i, mid-1);
        root.right = helper(nums, mid+1, j);
        return root;
    }
}
