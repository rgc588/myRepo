package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/19/2017.
 */
public class _69_E_SqrtX {
    public int mySqrt(int x) {
        if (x <= 0) return 0;
        int start = 1;
        int end = x;
        while(start < end) {
            int mid = start + (end - start + 1)/2;
            if (mid == x/mid) return mid;
            if (mid > x/mid) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        return start;
    }
}
