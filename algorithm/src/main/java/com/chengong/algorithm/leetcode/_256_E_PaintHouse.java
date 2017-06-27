package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/28/2017.
 */
public class _256_E_PaintHouse {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int[] red = new int[costs.length];
        int[] blue = new int[costs.length];
        int[] green = new int[costs.length];
        red[0] = costs[0][0];
        blue[0] = costs[0][1];
        green[0] = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            red[i] = Math.min(blue[i-1], green[i-1]) + costs[i][0];
            blue[i] = Math.min(red[i-1], green[i-1]) + costs[i][1];
            green[i] = Math.min(red[i-1], blue[i-1]) + costs[i][2];
        }
        return Math.min(Math.min(red[costs.length-1], blue[costs.length-1]),green[costs.length-1]);
    }
}
