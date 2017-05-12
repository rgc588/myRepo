package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by cheng on 5/1/2017.
 */
public class _145_H_BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        if (root == null) return rst;
        TreeNode p = null;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()) {
            TreeNode n = s.peek();
            if ((n.left == null && n.right == null) || (p != null && (n.left == p || n.right == p))) {
                s.pop();
                rst.add(n.val);
                p = n;
                continue;
            }
            if (n.right != null && n.right != p) {
                s.push(n.right);
            }
            if (n.left != null && n.left != p) {
                s.push(n.left);
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;
        _145_H_BinaryTreePostorderTraversal sol = new _145_H_BinaryTreePostorderTraversal();
        sol.postorderTraversal(root);
    }
}
