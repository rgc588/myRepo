package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.UndirectedGraphNode;

import java.util.*;

/**
 * Created by cheng on 4/27/2017.
 */
public class _133_M_CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        map.put(node, new UndirectedGraphNode(node.label));
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            UndirectedGraphNode n = q.remove();
            for (UndirectedGraphNode each : n.neighbors) {
                UndirectedGraphNode tmp = null;
                if (map.containsKey(each)) {
                    tmp = map.get(each);
                } else {
                    tmp = new UndirectedGraphNode(each.label);
                    map.put(each, tmp);
                    q.add(each);
                }
                map.get(n).neighbors.add(tmp);
            }
        }
        return map.get(node);
    }
}
