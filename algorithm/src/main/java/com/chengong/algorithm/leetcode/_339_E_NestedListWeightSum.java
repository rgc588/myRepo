package com.chengong.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by cheng on 5/28/2017.
 */
public class _339_E_NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        int sum = 0;
        if (nestedList == null) return sum;
        int depth = 1;
        Queue<NestedInteger> q = new LinkedList<>();
        for (NestedInteger ni : nestedList) {
            q.add(ni);
        }
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                NestedInteger ni = q.remove();
                if(ni.isInteger()) {
                    sum += ni.getInteger()*depth;
                } else {
                    for (NestedInteger n : ni.getList()) {
                        q.add(n);
                    }
                }
            }
            depth++;
        }
        return sum;
    }

    public int depthSum2(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> nl, int depth) {
        int sum = 0;
        if (nl == null) return sum;
        for (NestedInteger ni : nl) {
            if (ni.isInteger()) {
                sum += ni.getInteger()*depth;
            } else {
                sum += helper(ni.getList(), depth+1);
            }
        }
        return sum;
    }
}
