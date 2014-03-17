package com.chengong.test.algorithm;

import com.chengong.algorithm.BinaryTreeNode;
import com.chengong.algorithm.LCAInBinaryTree;
import org.junit.Test;

/**
 * Created by chengong on 3/14/14.
 */
public class LCAInBinaryTreeTest {

    @Test
    public void test() {

        BinaryTreeNode root = new BinaryTreeNode(3);
        BinaryTreeNode node1 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(1);
        BinaryTreeNode node3 = new BinaryTreeNode(6);
        BinaryTreeNode node4 = new BinaryTreeNode(2);
        BinaryTreeNode node5 = new BinaryTreeNode(0);
        BinaryTreeNode node6 = new BinaryTreeNode(8);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node8 = new BinaryTreeNode(4);
        //node outside the root
        BinaryTreeNode node9 = new BinaryTreeNode(100);

        root.setLeft(node1);
        root.setRight(node2);

        node1.setLeft(node3);
        node1.setRight(node4);

        node2.setLeft(node5);
        node2.setRight(node6);

        node4.setLeft(node7);
        node4.setRight(node8);

        assert node1 == LCAInBinaryTree.find(root, node7, node3);
        assert node8 == LCAInBinaryTree.find(root, node9, node8);
    }
}
