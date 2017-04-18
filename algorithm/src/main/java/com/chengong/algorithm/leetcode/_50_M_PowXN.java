package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/18/2017.
 */
public class _50_M_PowXN {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        long m = n;
        if (m < 0) {
            x=1/x;
            m = -m;
        }
        double rst = 1;
        while(m>0) {
            if (m%2==1) {
                rst *= x;
            }
            x = x*x;
            m=m/2;
        }
        return rst;
    }
}
