package com.chengong.algorithm.leetcode;

import java.util.*;

/**
 * Created by cheng on 5/11/2017.
 */
public class _207_M_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[][] p = prerequisites;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] dps = new int[n];
        for (int i = 0; i < p.length; i++) {
            if (map.containsKey(p[i][1])){
                map.get(p[i][1]).add(p[i][0]);
            } else {
                map.put(p[i][1], new HashSet<>(Arrays.asList(p[i][0])));
            }
            dps[p[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (dps[i] == 0) {
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int c = q.remove();
            if (map.containsKey(c)) {
                for (Integer each : map.get(c)) {
                    if (--dps[each] == 0) {
                        q.add(each);
                    }
                }
            }
            count++;
        }
        return count == n;
    }

    public static void main(String[] args) {
        int n = 2;
        int[][] p = new int[][] {{1,0}};
        _207_M_CourseSchedule sol = new _207_M_CourseSchedule();
        sol.canFinish(n, p);
    }
}
