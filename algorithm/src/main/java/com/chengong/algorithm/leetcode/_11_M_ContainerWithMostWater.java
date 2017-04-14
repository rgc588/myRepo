package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/3/2017.
 */
public class _11_M_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        if (height == null || height.length < 2) return max;
        int i = 0;
        int j = height.length-1;
        while(i < j) {
            if (height[i] < height[j]) {
                int v = height[i];
                max = Math.max(height[i]*(j-i), max);
                while(i < j && height[i] <= v) {
                    i++;
                }
            } else {
                int v = height[j];
                max = Math.max(height[j]*(j-i), max);
                while(i < j && height[j] <= v) {
                    j--;
                }
            }
        }
        return max;
    }
}
