package com.chengong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cheng on 4/25/2017.
 */
public class _118_M_PascalSTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rst = new ArrayList<>();
        if (numRows <= 0) return rst;
        rst.add(new ArrayList<>(Arrays.asList(1)));
        if (numRows == 1) return rst;
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i+1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(rst.get(i-1).get(j) + rst.get(i-1).get(j-1));
                }
            }
            rst.add(row);
        }
        return rst;
    }
}
