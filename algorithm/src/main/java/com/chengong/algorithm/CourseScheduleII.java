package com.chengong.algorithm;

import java.util.*;

/**
 * Created by chengong on 10/13/15.
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] cache = new int[numCourses];
        int[][] p = prerequisites;
        List<Integer> rst = new ArrayList<>();
        Integer index = 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < p.length; i++) {
            if(map.containsKey(p[i][1])) {
                map.get(p[i][1]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(p[i][1],list);
            }
        }

        for(int i = 0; i < numCourses; i++) {
            if(!helper(map, cache, i, rst)) return new int[0];
        }

        int[] rstArray = new int[rst.size()];
        for(int i = 0; i < rst.size(); i++) {
            rstArray[i] = rst.get(i);
        }
        return rstArray;
    }

    private boolean helper(Map<Integer, List<Integer>> map, int[] cache, int n, List<Integer> rst) {
        if(cache[n] == -1) return false;
        if(cache[n] == 1) return true;

        cache[n] = -1;
        if(map.containsKey(n)) {
            for(int each : map.get(n)) {
                helper(map, cache, each, rst);
            }
        }
        cache[n] = 1;
        return true;
    }

    public static void main(String[] args) {
        CourseScheduleII test = new CourseScheduleII();
        int[] rst = test.findOrder(8, new int[][]{{1, 0}, {2, 6}, {1, 7}, {5, 1}, {6, 4}, {7, 0}, {0, 5}, {5, 1}, {6, 4}});
        System.out.println(Arrays.asList(rst).toString());
    }
}
