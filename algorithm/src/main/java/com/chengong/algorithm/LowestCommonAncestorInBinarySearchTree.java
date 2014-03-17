package com.chengong.algorithm;

import sun.management.resources.agent_fr;

/**
 * Created by chengong on 3/13/14.
 */
public class LowestCommonAncestorInBinarySearchTree {

    public static BinaryTreeNode find(BinaryTreeNode root, BinaryTreeNode firstNode, BinaryTreeNode secondNode){
        if(firstNode == secondNode) return firstNode;
        if(root == firstNode || root == secondNode){
            return root == firstNode ? firstNode : secondNode;
        }
        if((firstNode.getValue() <= root.getValue() && secondNode.getValue() > root.getValue())
                || (firstNode.getValue() > root.getValue() && secondNode.getValue() <= root.getValue())){
            return root;
        } else {
            if(firstNode.getValue() <= root.getValue() && secondNode.getValue() <= root.getValue()){
                return find(root.getLeft(), firstNode, secondNode);
            }
            if(firstNode.getValue() > root.getValue() && secondNode.getValue() > root.getValue()){
                return find(root.getRight(), firstNode, secondNode);
            }
        }
        return null;
    }
}
