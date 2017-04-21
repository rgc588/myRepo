package com.chengong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 4/20/2017.
 */
public class _89_M_GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> rst = new ArrayList<>();
        rst.add(0);
        if (n <= 0) return rst;
        int p = 1;
        for (int i = 0; i < n; i++) {
            int l = rst.size();
            for (int j = l-1; j>=0; j--) {
                rst.add(rst.get(j)+p);
            }
            p *= 2;
        }
        return rst;
    }
}
