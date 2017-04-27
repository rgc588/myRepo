package com.chengong.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cheng on 4/26/2017.
 */
public class _128_H_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = 0;
                int right = 0;
                if (map.containsKey(n-1)) left = map.get(n-1);
                if (map.containsKey(n+1)) right = map.get(n+1);
                max = Math.max(max, left+right+1);
                map.put(n, 0);//to remove duplicate
                map.put(n-left, left+right+1);
                map.put(n+right, left+right+1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = new int[] {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
        _128_H_LongestConsecutiveSequence sol = new _128_H_LongestConsecutiveSequence();
        System.out.print(sol.longestConsecutive(input));
    }
}
