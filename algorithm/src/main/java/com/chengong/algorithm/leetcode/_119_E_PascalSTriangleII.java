package com.chengong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 4/25/2017.
 */
public class _119_E_PascalSTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> rst = new ArrayList<>();
        if (rowIndex < 0) return rst;
        rst.add(1);
        if (rowIndex == 0) return rst;
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    tmp.add(1);
                } else {
                    tmp.add(rst.get(j)+rst.get(j-1));
                }
            }
            rst = tmp;
        }
        return rst;
    }
}
