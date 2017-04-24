package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by cheng on 4/21/2017.
 */
public class _94_M_BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> left = inorderTraversal(root.left);
        left.add(root.val);
        List<Integer> right = inorderTraversal(root.right);
        left.addAll(right);
        return left;
    }
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        if (root == null) return rst;
        TreeNode p = null;
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null) {
            stack.push(root);
            root = root.left;
        }
        while(!stack.isEmpty()) {
            TreeNode n = stack.pop();
            rst.add(n.val);
            TreeNode r = n.right;
            while(r != null) {
                stack.push(r);
                r = r.left;
            }
        }
        return rst;
    }
}
