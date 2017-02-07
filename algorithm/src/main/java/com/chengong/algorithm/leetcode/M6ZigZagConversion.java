package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 2/7/2017.
 */
public class M6ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows < 1) throw new IllegalArgumentException("Invalid row number");
        if (numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows-1) {
                for (int j = i; j < s.length(); j+=(numRows-1)*2) {
                    sb.append(s.charAt(j));
                }
            } else {
                int offset1 = i;
                int offset2 = (numRows-1)*2-i;
                for (int j = 0; j+offset1 < s.length(); j+=(numRows-1)*2) {
                    sb.append(s.charAt(j+offset1));
                    if(j+offset2>=s.length()) break;
                    sb.append(s.charAt(j+offset2));
                }
            }
        }
        return sb.toString();
    }
}
