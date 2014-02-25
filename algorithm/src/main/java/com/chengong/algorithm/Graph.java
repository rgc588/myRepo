package com.chengong.algorithm;

import java.util.*;

/**
 * Created by chengong on 2/25/14.
 */
public class Graph {
    ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
    Node<String> rootNode;
    Integer nodeCount;

    public Graph (Node<String> rootNode) {
        this.rootNode = rootNode;
    }

    private void countNodes(Node<String> rootNode){
        if(rootNode == null) throw new IllegalArgumentException("Input rootNode should NOT be NULL");
        Set<Node<String>> visitedNodes = new HashSet<Node<String>>();
        nodeCount = 0;
        Iterator<Node<String>> neighbors = rootNode.getNeighbors().iterator();


    }

    private void buildMatrix(Node<String> rootNode){
        if(rootNode == null) throw new IllegalArgumentException("Input rootNode should NOT be NULL");
        nodeCount = 0;
        Set<Node<String>> visitedNodes = new HashSet<Node<String>>();
        Queue<Node<String>> queue = new LinkedList<Node<String>>();

        queue.add(rootNode);

        while(!queue.isEmpty()){

        }
    }

    private void addNodeToMatrix(Node<String> node){

    }
}
