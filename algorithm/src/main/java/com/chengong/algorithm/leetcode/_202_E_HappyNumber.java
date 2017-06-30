package com.chengong.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cheng on 5/8/2017.
 */
public class _202_E_HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1 && !set.contains(n)) {
            set.add(n);
            int tmp = 0;
            while(n != 0) {
                tmp += (n%10)*(n%10);
                n/=10;
            }
            n = tmp;
        }
        return n == 1;
    }
}
