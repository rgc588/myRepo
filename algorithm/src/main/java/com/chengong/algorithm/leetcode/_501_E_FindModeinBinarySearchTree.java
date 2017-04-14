package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 3/7/2017.
 */
public class _501_E_FindModeinBinarySearchTree {
    int count = 1;
    int max = 0;
    Integer prev = null;
    public int[] findMode(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        helper(root, rst);
        int[] r = new int[rst.size()];
        for (int i = 0; i < rst.size(); i++) {
            r[i] = rst.get(i);
        }
        return r;
    }

    private void helper(TreeNode root, List<Integer> rst) {
        if (root == null) return;
        helper(root.left, rst);
        if (prev != null) {
            if (prev == root.val) {
                count++;
            } else {
                count = 1;
            }
        }
        if (count == max) {
            rst.add(root.val);
        } else if (count > max) {
            rst.clear();
            rst.add(root.val);
            max = count;
        }
        prev = root.val;
        helper(root.right, rst);
    }
}
