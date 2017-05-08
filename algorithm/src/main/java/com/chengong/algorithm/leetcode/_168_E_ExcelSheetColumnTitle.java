package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/6/2017.
 */
public class _168_E_ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        if (n <= 0) return sb.toString();
        while(n > 0) {
            sb.insert(0,(char)('A'+(n-1)%26));
            n=(n-1)/26;
        }
        return sb.toString();
    }
}
