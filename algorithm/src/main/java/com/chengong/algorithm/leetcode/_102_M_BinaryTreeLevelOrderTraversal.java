package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by cheng on 4/24/2017.
 */
public class _102_M_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<>();
        if (root == null) return rst;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Queue<TreeNode> tmp = new LinkedList<>();
            List<Integer> level = new ArrayList<>();
            while(!q.isEmpty()) {
                TreeNode n = q.remove();
                level.add(n.val);
                if (n.left != null) tmp.add(n.left);
                if (n.right != null) tmp.add(n.right);
            }
            rst.add(level);
            q = tmp;
        }
        return rst;
    }
}
