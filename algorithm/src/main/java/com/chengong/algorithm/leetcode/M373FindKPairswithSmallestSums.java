package com.chengong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by cheng on 4/12/2017.
 */
public class M373FindKPairswithSmallestSums {
    private int[] ref1;
    private int[] ref2;

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> rst = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return rst;
        ref1 = nums1;
        ref2 = nums2;
        Comparator<int[]> mc = new MyComparator();
        PriorityQueue<int[]> q = new PriorityQueue<>(100, mc);
        q.add(new int[] {0,0});
        for (int i = 0; i < k; i++) {
            if (q.isEmpty()) break;
            int[] p = q.remove();
            rst.add(new int[] {nums1[p[0]], nums2[p[1]]});
            if (p[1] == 0) {
                if(p[0]+1 < nums1.length) q.add(new int[] {p[0]+1, 0});
            }
            if(p[1]+1 < nums2.length) q.add(new int[] {p[0], p[1]+1});
        }
        return rst;
    }

    private class MyComparator implements Comparator<int[]> {
        public int compare(int[] l, int[] r) {
            return (ref1[l[0]]+ref2[l[1]]) - (ref1[r[0]]+ref2[r[1]]);
        }
    }
}
