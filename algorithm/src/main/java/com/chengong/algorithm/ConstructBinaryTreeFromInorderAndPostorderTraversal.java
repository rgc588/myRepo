package com.chengong.algorithm;

import com.chengong.algorithm.leetcode.BaseClasses.TreeNode;

/**
 * Created by chengong on 11/11/15.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] in, int[] p, int rootIndex, int left, int right) {
        if(left > right) return null;
        TreeNode root = new TreeNode(p[rootIndex]);
        if(left == right) {
            return root;
        }

        int i = left;
        for(; i <= right; i++) {
            if(in[i] == p[rootIndex]) break;
        }

        TreeNode l = helper(in, p, rootIndex - (right - i) - 1, left, i - 1);
        TreeNode r = helper(in, p, rootIndex - 1, i + 1, right);
        root.left = l;
        root.right = r;
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = new int[] {1,2,3,4};
        int[] postorder = new int[] {3,4,2,1};

        ConstructBinaryTreeFromInorderAndPostorderTraversal test = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        TreeNode rst = test.buildTree(inorder, postorder);
        System.out.println("done");
    }
}
