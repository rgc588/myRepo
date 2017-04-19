package com.chengong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 4/18/2017.
 */
public class _51_H_NQueens {
    public List<List<String>> solveNQueens(int n) {
        int[] mem = new int[n];
        for (int i = 0; i < mem.length; i++) {
            mem[i]=-1;
        }
        List<List<String>> rst = new ArrayList<>();
        helper(0, n, mem, rst);
        return rst;
    }

    private void helper(int index, int n, int[] mem, List<List<String>> rst) {
        if (index == n) {
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < mem.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < mem.length; j++) {
                    if (j==mem[i]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                tmp.add(sb.toString());
            }
            rst.add(tmp);
            return;
        }
        for (int i = 0; i < mem.length; i++) {
            if (mem[i]==-1) {
                if (valid(mem, index, i)) {
                    mem[i]=index;
                    helper(index+1,n,mem,rst);
                    mem[i]=-1;
                }
            }
        }
    }

    private boolean valid(int[] mem, int r, int c) {
        int row = r;
        int col = c;
        while(col < mem.length && row >= 0) {
            if (mem[col]==row) return false;
            row--;
            col++;
        }
        row = r;
        col = c;
        while(col >= 0 && row >= 0) {
            if (mem[col]==row) return false;
            row--;
            col--;
        }
        return true;
    }
}
