package com.chengong.algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import com.rits.cloning.Cloner;

/**
 * Created by chengong on 2/25/14.
 */
public class CloneGraph {
    private static Cloner cloner = new Cloner();

    public static Node<String> depthFirstRecursive(Node<String> rootNode){

        if(rootNode == null) throw new IllegalArgumentException("Root should not be null");

        Map<Node<String>, Node<String>> visitedMap = new HashMap<Node<String>, Node<String>>();

        return recursive(rootNode, visitedMap);
    }

    private static Node<String> recursive(Node<String> rootNode, Map<Node<String>, Node<String>> visitedMap){
        Node<String> newRoot = visitAndCloneNode(rootNode, visitedMap);

        if(rootNode.getNeighbors() == null || rootNode.getNeighbors().isEmpty()){
            return newRoot;
        } else {
            Iterator<Node<String>> iterator = rootNode.getNeighbors().iterator();
            while (iterator.hasNext()){
                Node<String> neighbor = iterator.next();
                if(visitedMap.keySet().contains(neighbor)){
                    newRoot.addNeighbor(visitedMap.get(neighbor));
                } else {
                    Node<String> newNode = recursive(neighbor, visitedMap);
                    newRoot.addNeighbor(newNode);
                }
            }
            return newRoot;
        }
    }

    private static Node<String> visitAndCloneNode(Node<String> node, Map<Node<String>, Node<String>> visitedMap){
        String newValue = node.getValue() + node.getValue();
        Node<String> newNode = new Node<String>(newValue);
        visitedMap.put(node, newNode);
        return newNode;
    }
}
