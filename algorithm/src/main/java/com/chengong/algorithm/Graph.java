package com.chengong.algorithm;

import java.util.*;

/**
 * Created by chengong on 2/25/14.
 */
public class Graph {
    private static final int NO_LINK = 0;
    private static final int LINK = 1;
    ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
    ArrayList<Node<String>> elements = new ArrayList<Node<String>>();
    Node<String> rootNode;
    Integer nodeCount;

    public Graph (Node<String> rootNode) {
        this.rootNode = rootNode;
        countNodes(rootNode);
        initMatrix();
        buildMatrix(rootNode);
    }

    private void initMatrix(){
        for(int i = 0; i < nodeCount; i++){
            ArrayList<Integer> line = new ArrayList<Integer>();
            for(int j = 0; j < nodeCount; j++){
                line.add(NO_LINK);
            }
            matrix.add(line);
        }
    }

    private void countNodes(Node<String> rootNode){
        if(rootNode == null) throw new IllegalArgumentException("Input rootNode should NOT be NULL");
        Set<Node<String>> visitedNodes = new HashSet<Node<String>>();
        nodeCount = countRecursive(rootNode, visitedNodes);
    }

    private Integer countRecursive(Node<String> node, Set<Node<String>> visitedNodes){
        if(node == null) throw new IllegalArgumentException("Input rootNode should NOT be NULL");
        visitedNodes.add(node);
        Set<Node<String>> neighbors = node.getNeighbors();
        if(neighbors.isEmpty()){
            return 1;
        } else {
            Integer count = 0;
            Iterator<Node<String>> iterator = neighbors.iterator();
            while (iterator.hasNext()){
                Node<String> next = iterator.next();
                if(!visitedNodes.contains(next)){
                    count = count + countRecursive(next, visitedNodes);
                }
            }
            return count + 1;
        }
    }

    private void buildMatrix(Node<String> rootNode){
        if(rootNode == null) throw new IllegalArgumentException("Input rootNode should NOT be NULL");
        Set<Node<String>> visitedNodes = new HashSet<Node<String>>();
        Queue<Node<String>> queue = new LinkedList<Node<String>>();

        queue.add(rootNode);
        elements.add(rootNode);
        while(!queue.isEmpty()){
            Node<String> node = queue.poll();
            Set<Node<String>> neighbors = node.getNeighbors();
            Iterator<Node<String>> iterator = neighbors.iterator();
            while(iterator.hasNext()){
                Node<String> next = iterator.next();
                    if(!elements.contains(next)){
                        elements.add(next);
                    }
                    int indexOfParent = elements.indexOf(node);
                    int indexOfChild = elements.indexOf(next);
                    matrix.get(indexOfParent).set(indexOfChild, LINK);
                if(!visitedNodes.contains(next))
                    queue.add(next);
            }
            visitedNodes.add(node);
        }
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("   ");
        for(Node<String> node : elements){
            stringBuilder.append(node.getValue() + " | ");
        }
        stringBuilder.append("\n");

        for(int i = 0; i < nodeCount; i ++){
            stringBuilder.append(elements.get(i) + " | ");
            ArrayList<Integer> thisLine = matrix.get(i);
            for(int j = 0; j < nodeCount; j++){
                stringBuilder.append(thisLine.get(j) + " | ");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
