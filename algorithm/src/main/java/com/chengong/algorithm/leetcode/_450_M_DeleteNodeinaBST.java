package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.TreeNode;

/**
 * Created by cheng on 5/28/2017.
 */
public class _450_M_DeleteNodeinaBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                TreeNode n = root.right;
                while(n.left != null) {
                    n = n.left;
                }
                root.val = n.val;
                root.right = deleteNode(root.right, n.val);
            }
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
        TreeNode n2 = new TreeNode (2);
        TreeNode n4 = new TreeNode (4);
        TreeNode n7 = new TreeNode (7);
        root.left = n3;
        root.right = n6;
        n3.left = n2;
        n3.right = n4;
        n6.right = n7;
        _450_M_DeleteNodeinaBST sol = new _450_M_DeleteNodeinaBST();
        sol.deleteNode(root, 3);
    }
}
