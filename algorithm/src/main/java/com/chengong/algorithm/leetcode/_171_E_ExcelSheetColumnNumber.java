package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/6/2017.
 */
public class _171_E_ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if (s == null || s.isEmpty()) return 0;
        int rst = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            rst = rst*26 + c-'A'+1;
        }
        return rst;
    }
}
