package com.chengong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 4/18/2017.
 */
public class _60_M_PermutationSequence {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> nums = new ArrayList<>();
        int p = 1;
        for (int i = 1; i <= n; i++) {
            nums.add(i);
            p *= i;
        }
        while(n > 0) {
            p /= n;
            int index = (k-1)/p;
            sb.append(nums.get(index));
            nums.remove(index);
            k = k%p == 0 ? p : k%p;
            n--;
        }
        return sb.toString();
    }
}
