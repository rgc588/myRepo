package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 5/1/2017.
 */
public class _145_H_BinaryTreePostorderTraversal {
    List<Integer> rst = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        helper(root);
        return rst;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        helper(root.right);
        rst.add(root.val);
    }
}
