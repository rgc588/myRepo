package com.chengong.algorithm.leetcode.BaseClasses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 4/27/2017.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}