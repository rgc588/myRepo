package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/17/2017.
 */
public class _45_H_JumpGameII {
    public int jump(int[] A) {
        int count = 0;
        int current = 0;
        int max = 0;
        for (int i = 0; i < A.length-1; i++) {
            max = Math.max(A[i] + i, max);
            if (current == i) {
                current = max;
                count++;
                if (current >= A.length-1) break;
            }
        }
        return count;
    }
}
