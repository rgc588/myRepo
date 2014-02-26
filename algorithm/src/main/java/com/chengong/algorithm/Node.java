package com.chengong.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chengong on 2/25/14.
 */
public class Node<T> {

    private T value;
    private Set<Node<T>> neighbors;

    public Node(T value, Set<Node<T>> neighbors) {
        this.value = value;
        this.neighbors = neighbors;
    }

    public Node(T value) {
        this.value = value;
        this.neighbors = new HashSet<Node<T>>();
    }

    public void addNeighbor(Node<T> neighbor){
        neighbors.add(neighbor);
        neighbor.getNeighbors().add(this);
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNeighbors(Set<Node<T>> neighbors) {
        this.neighbors = neighbors;
    }

    public T getValue() {
        return value;
    }

    public Set<Node<T>> getNeighbors() {
        return neighbors;
    }

    @Override
    public String toString(){
        return value.toString();
    }
}
