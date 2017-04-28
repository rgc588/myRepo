package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/27/2017.
 */
public class _134_M_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = gas.length-1;
        int end = 0;
        int tank = gas[start] - cost[start];
        while(end < start) {
            if (tank < 0) {
                start--;
                tank += gas[start] - cost[start];
            } else {
                tank += gas[end] - cost[end];
                end++;
            }
        }
        return tank >=0 ? start : -1;
    }
}
