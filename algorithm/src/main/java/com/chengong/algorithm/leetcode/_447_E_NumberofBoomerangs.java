package com.chengong.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chengong on 6/27/17.
 */
public class _447_E_NumberofBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j == i) continue;
                int d = distance(points[i], points[j]);
                map.put(d, map.getOrDefault(d, 0)+1);
            }
            for (int v : map.values()) {
                count += v*(v-1);
            }
        }
        return count;
    }

    private int distance(int[] p1, int[] p2) {
        return (p1[0]-p2[0])*(p1[0]-p2[0])+(p1[1]-p2[1])*(p1[1]-p2[1]);
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {{0,0},{1,0},{2,0}};
        _447_E_NumberofBoomerangs sol = new _447_E_NumberofBoomerangs();
        System.out.print(sol.numberOfBoomerangs(input));
    }
}
