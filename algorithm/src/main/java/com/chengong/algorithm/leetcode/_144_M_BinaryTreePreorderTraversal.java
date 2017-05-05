package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by cheng on 5/1/2017.
 */
public class _144_M_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        helper(root, rst);
        return rst;
    }

    private void helper(TreeNode root, List<Integer> rst) {
        if (root == null) return;
        rst.add(root.val);
        helper(root.left, rst);
        helper(root.right, rst);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        if (root == null) return rst;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()) {
            TreeNode n = s.pop();
            rst.add(n.val);
            if (n.right != null) s.push(n.right);
            if (n.left != null) s.push(n.left);
        }
        return rst;
    }
}
