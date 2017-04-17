package com.chengong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 4/17/2017.
 */
public class _22_M_GenerateParentheses {
    private int count = 0;
    private int m;
    public List<String> generateParenthesis(int n) {
        m = n;
        List<String> rst = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(sb, rst);
        return rst;
    }

    private void helper (StringBuilder sb, List<String> rst) {
        if (sb.length() == m*2) {
            if (count == 0) rst.add(sb.toString());
            return;
        }
        if (count < m) {
            sb.append('(');
            count++;
            helper(sb, rst);
            count--;
            sb.deleteCharAt(sb.length()-1);
        }
        if (count > 0) {
            count--;
            sb.append(')');
            helper(sb, rst);
            sb.deleteCharAt(sb.length()-1);
            count++;
        }
    }
}
