package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by cheng on 4/25/2017.
 */
public class _117_M_PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Queue<TreeLinkNode> tmp = new LinkedList<>();
            while(!q.isEmpty()){
                TreeLinkNode n = q.remove();
                n.next = q.peek();
                if (n.left != null) tmp.add(n.left);
                if (n.right != null) tmp.add(n.right);
            }
            q = tmp;
        }
    }
}
