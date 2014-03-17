package com.chengong.algorithm;

/**
 * Created by chengong on 3/14/14.
 */
public class LCAInBinaryTree {


    /**
     * return LCA if both firstNode and secondNode under root
     * return the node under root if the other is not under the root
     * return null if both are not under the root
     * @param root
     * @param firstNode
     * @param secondNode
     * @return
     */
    public static BinaryTreeNode find(BinaryTreeNode root, BinaryTreeNode firstNode, BinaryTreeNode secondNode){
        if(firstNode == null || secondNode == null) throw new IllegalArgumentException("first and second node should not be null");
        if(root == null) return null;
        if(root == firstNode || root == secondNode) return root;

        BinaryTreeNode leftLCA = find(root.getLeft(), firstNode, secondNode);
        BinaryTreeNode rightLCA = find(root.getRight(), firstNode, secondNode);

        if(leftLCA != null && rightLCA != null) return root;
        return leftLCA != null ? leftLCA : rightLCA;
    }

}