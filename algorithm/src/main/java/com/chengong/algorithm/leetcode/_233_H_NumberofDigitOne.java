package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/18/2017.
 */
public class _233_H_NumberofDigitOne {
    public int countDigitOne(int n) {
        int low = 0;
        int lol = 1;
        int sum = 0;
        while(n > 0) {
            int d = n%10;
            sum += n/10*lol;
            if (d == 1) {
                sum += low+1;
            } else if (d > 1) {
                sum += lol;
            }
            low = low+d*lol;
            lol *= 10;
            n = n/10;
        }
        return sum;
    }
}
