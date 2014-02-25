package com.chengong.algorithm;

import java.util.*;

/**
 * Created by chengong on 2/25/14.
 */
public class TraverseGraph {
    /**
     * traverse a graph with depth first and recursive approach
     * @param rootNode
     * @param <P>
     */
    public static <P> void depthFirstRecursive(Node<P> rootNode){
        Set<Node<P>> visitedNodeSet = new HashSet<Node<P>>();
        traverseGraph(rootNode, visitedNodeSet);
    }

    private static <T> void traverseGraph(Node<T> rootNode, Set<Node<T>> visitedNodeSet){
        if(rootNode == null) throw new IllegalArgumentException("Root node should not be null");

        if(visitedNodeSet.contains(rootNode)){
            return;
        } else {
            visitNode(rootNode, visitedNodeSet);
        }

        Set<Node<T>> neighbors = rootNode.getNeighbors();

        if(neighbors == null || neighbors.isEmpty()){
            return;
        } else {
            for(Node<T> each: neighbors){
                traverseGraph(each, visitedNodeSet);
            }
        }
    }

    /**
     * traverse the graph with depth first and iterative approach
     * @param rootNode
     * @param <T>
     */
    public static <T> void depthFirstIterative(Node<T> rootNode){
        if(rootNode == null) throw new IllegalArgumentException("Root node should not be null");
        Set<Node<T>> visitedNodeSet = new HashSet<Node<T>>();
        Stack<Node<T>> stack = new Stack<Node<T>>();
        stack.push(rootNode);
        visitNode(rootNode, visitedNodeSet);

        while (!stack.isEmpty()){
            Node<T> node = stack.peek();
            Node<T> neighborNode = returnNextUnVisitedNeighbor(node, visitedNodeSet);
            if(neighborNode != null){
                visitNode(neighborNode, visitedNodeSet);
                stack.push(neighborNode);
            } else {
                stack.pop();
            }
        }
    }

    /**
     * traverse a graph with breadth first iterative approach
     * @param rootNode
     * @param <T>
     */
    public static <T> void breadthFirstIterative(Node<T> rootNode){
        if(rootNode == null) throw new IllegalArgumentException("Root node should not be null");
        Set<Node<T>> visitedNodeSet = new HashSet<Node<T>>();
        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        visitNode(rootNode, visitedNodeSet);
        queue.add(rootNode);
        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            Iterator neighbors = node.getNeighbors().iterator();
            while (neighbors.hasNext()){
                Node<T> next = (Node<T>) neighbors.next();
                if(visitedNodeSet.contains(next)){

                } else {
                    visitNode(next, visitedNodeSet);
                    queue.add(next);
                }
            }
        }
    }

    private static <T> Node<T> returnNextUnVisitedNeighbor(Node<T> node, Set<Node<T>> visitedNodeSet){
        Iterator<Node<T>> iterator = node.getNeighbors().iterator();
        while (iterator.hasNext()){
            Node<T> next = iterator.next();
            if(!visitedNodeSet.contains(next)){
                return next;
            }
        }
        return null;
    }

    private static <T> void visitNode(Node<T> nodeToBeVisited, Set<Node<T>> visitedNodeSet){
        System.out.println(nodeToBeVisited.getValue());
        visitedNodeSet.add(nodeToBeVisited);
    }
}
