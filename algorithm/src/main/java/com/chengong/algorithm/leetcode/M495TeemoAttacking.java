package com.chengong.algorithm.leetcode;

import java.util.Stack;

/**
 * Created by cheng on 3/10/2017.
 */
public class M495TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        Stack<Integer[]> stack = new Stack<>();
        for (int i = 0; i < timeSeries.length; i++) {
            if (!stack.isEmpty() && stack.peek()[1] >= timeSeries[i]) {
                stack.peek()[1] = timeSeries[i] + duration - 1;
            } else {
                stack.push(new Integer[] {timeSeries[i], timeSeries[i] + duration - 1});
            }
        }
        int rst = 0;
        while(!stack.isEmpty()) {
            Integer[] seg = stack.pop();
            rst += seg[1] - seg[0] + 1;
        }
        return rst;
    }

    public int findPoisonedDuration2(int[] timeSeries, int duration) {
        int max = -1;
        int rst = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (timeSeries[i] <= max) {
                rst += (timeSeries[i] + duration - 1) - max;
            } else {
                rst += duration;
            }
            max = timeSeries[i] + duration - 1;
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] timeSeries = new int[] {1,4};
        M495TeemoAttacking sol = new M495TeemoAttacking();
        int rst = sol.findPoisonedDuration(timeSeries, 2);
        System.out.println(rst);
    }
}
