package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by cheng on 2/28/2017.
 */
public class _515_M_FindLargestValueinEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> rst = new ArrayList<>();
        if (root == null) return rst;
        q.add(root);
        while(!q.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = q.size();
            for (int i = size; i > 0; i--) {
                TreeNode n = q.poll();
                max = Math.max(max, n.val);
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
            }
            rst.add(max);
        }
        return rst;
    }

    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        helper(root, 0, rst);
        return rst;
    }

    private void helper(TreeNode root, int level, List<Integer> rst) {
        if (root == null) return;
        if (level > rst.size() - 1) {
            rst.add(root.val);
        } else {
            rst.set(level, Math.max(root.val, rst.get(level)));
        }
        helper(root.left, level+1, rst);
        helper(root.right, level+1, rst);
    }
}
