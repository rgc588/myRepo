package com.chengong.algorithm.leetcode;

import java.util.*;

/**
 * Created by cheng on 5/12/2017.
 */
public class _210_M_CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[][] p = prerequisites;
        int[] rst = new int[n];
        int index = 0;
        int[] dps = new int[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < p.length; i++) {
            if (map.containsKey(p[i][1])) {
                map.get(p[i][1]).add(p[i][0]);
            } else {
                map.put(p[i][1], new HashSet<>(Arrays.asList(p[i][0])));
            }
            dps[p[i][0]]++;
        }
        Queue<Integer> taken = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (dps[i] == 0) {
                taken.add(i);
                rst[index++] = i;
            }
        }
        while(!taken.isEmpty()) {
            int c = taken.remove();
            if (map.containsKey(c)) {
                for (int each : map.get(c)) {
                    if (--dps[each] == 0) {
                        taken.add(each);
                        rst[index++] = each;
                    }
                }
            }
        }
        return index == n ? rst : new int[0];
    }
}
