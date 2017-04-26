package com.chengong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cheng on 4/25/2017.
 */
public class _120_M_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        if (m == 0) return 0;
        int[] mem = new int[m];
        for (int i = 0; i < m; i++) {
            mem[i] = triangle.get(m-1).get(i);
        }
        for (int i = m-2; i >= 0; i--) {
            for (int j = 0; j <=i; j++) {
                mem[j] = Math.min(mem[j],mem[j+1]) + triangle.get(i).get(j);
            }
        }
        return mem[0];
    }
}
