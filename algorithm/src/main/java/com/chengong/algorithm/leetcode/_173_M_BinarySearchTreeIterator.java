package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.TreeNode;

import java.util.Stack;

/**
 * Created by cheng on 5/6/2017.
 */
public class _173_M_BinarySearchTreeIterator {
    TreeNode cur = null;
    Stack<TreeNode> s = new Stack<>();
    public _173_M_BinarySearchTreeIterator(TreeNode root) {
        cur = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cur != null || !s.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        while(cur != null) {
            s.push(cur);
            cur = cur.left;
        }
        TreeNode n = s.pop();
        cur = n.right;
        return n.val;
    }
}
