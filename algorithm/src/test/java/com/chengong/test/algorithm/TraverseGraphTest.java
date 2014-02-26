package com.chengong.test.algorithm;

import com.chengong.algorithm.CloneGraph;
import com.chengong.algorithm.Graph;
import com.chengong.algorithm.Node;
import com.chengong.algorithm.TraverseGraph;
import org.junit.Test;

/**
 * Created by chengong on 2/25/14.
 */
public class TraverseGraphTest {
    @Test
    public void test(){
        /**
         *                  A
         *           /      |       \
         *           B      C       D
         *          /  \  /
         *         E    F
         */
        Node<String> rootNode = new Node<String>("A");
        Node<String> nodeB = new Node<String>("B");
        Node<String> nodeC = new Node<String>("C");
        Node<String> nodeD = new Node<String>("D");
        Node<String> nodeE = new Node<String>("E");
        Node<String> nodeF = new Node<String>("F");

        rootNode.addNeighbor(nodeB);
        rootNode.addNeighbor(nodeC);
        rootNode.addNeighbor(nodeD);
        nodeB.addNeighbor(nodeE);
        nodeB.addNeighbor(nodeF);
        nodeC.addNeighbor(nodeF);

        System.out.println("depthFirstRecursive:");
        TraverseGraph.depthFirstRecursive(rootNode);
        System.out.println("depthFirstIterative:");
        TraverseGraph.depthFirstIterative(rootNode);
        System.out.println("breadthFirstIterative");
        TraverseGraph.breadthFirstIterative(rootNode);

        System.out.println("clone with depthFirstRecursive");
        Node<String> clonedNode = CloneGraph.depthFirstRecursive(rootNode);
        TraverseGraph.breadthFirstIterative(rootNode);
        TraverseGraph.breadthFirstIterative(clonedNode);

        Graph originalGraph = new Graph(rootNode);
        Graph clonedGraph = new Graph(clonedNode);

        System.out.println(originalGraph.toString());
        System.out.println(clonedGraph.toString());
    }
}
