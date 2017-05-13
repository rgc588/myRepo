package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 5/8/2017.
 */
public class _199_M_BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        helper(root, rst, 0);
        return rst;
    }

    private void helper(TreeNode root, List<Integer> rst, int level) {
        if (root == null) return;
        if (rst.size() == level) {
            rst.add(root.val);
        }
        helper(root.right, rst, level+1);
        helper(root.left, rst, level+1);
    }
}
