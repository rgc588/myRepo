package com.chengong.algorithm.leetcode;

import java.util.*;

/**
 * Created by cheng on 5/11/2017.
 */
public class _210_M_CourseScheduleII {
    /*
    BFS:
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] count = new int[numCourses];
        Map<Integer, List<Integer>> deps = new HashMap<>();
        int[] rst = new int[numCourses];
        int index = 0;
        for (int i = 0; i < prerequisites.length; i++) {
            if (!deps.containsKey(prerequisites[i][1])) deps.put(prerequisites[i][1], new ArrayList<>());
            deps.get(prerequisites[i][1]).add(prerequisites[i][0]);
            count[prerequisites[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) q.add(i);
        }
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                int n = q.remove();
                rst[index++]=n;
                for (int d : deps.get(n)) {
                    count[d]--;
                    if (count[d] == 0) q.add(d);
                }
                size--;
            }
        }
        return rst;
    }

    /*
    DFS: post order
     */
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        int[][] input = prerequisites;
        int n = numCourses;
        if (input == null || n <= 0) return new int[0];
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        boolean[] hasChild = new boolean[n];
        for (int i = 0; i < input.length; i++) {
            map.get(input[i][0]).add(input[i][1]);
            hasChild[input[i][1]] = true;
        }
        List<Integer> s = new ArrayList<>();
        HashSet<Integer> cur = new HashSet<>();
        HashSet<Integer> rst = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!hasChild[i]) {
                if (!helper(i, s, map, cur, rst)) return new int[0];
            }
        }
        if (s.size() < n) return new int[0];
        int[] ret = new int[s.size()];
        for (int i = 0; i < s.size(); i++) {
            ret[i] = s.get(i);
        }
        return ret;
    }

    private boolean helper(int i, List<Integer> s, List<List<Integer>> map, Set<Integer> cur, Set<Integer> rst) {
        if (cur.contains(i)) return false;
        if (rst.contains(i)) return true;
        cur.add(i);
        for (int p : map.get(i)) {
            if (!helper(p, s, map, cur, rst)) return false;
        }
        cur.remove(i);
        s.add(i);
        rst.add(i);
        return true;
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {{1,0}};
        _210_M_CourseScheduleII sol = new _210_M_CourseScheduleII();
        sol.findOrder(2, input);
    }
}
