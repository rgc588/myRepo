package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 2/16/2017.
 */
public class _8_M_StringToIntegerATOI {
    public int myAtoi(String str) {
        int i = 0;
        while(i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        int sign = 1;
        if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            if (str.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }
        long base = 0;
        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            base = base*10 + (long)(str.charAt(i) - '0');
            if (base > Integer.MAX_VALUE) {
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            i++;
        }
        return (int)(sign*base);
    }

    public int myAtoi2(String str) {
        int i = 0;
        int sign = 1;
        while(i < str.length()){
            char c = str.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            } else {
                if (c == '-' || c == '+') {
                    if (c == '-') sign = -1;
                    i++;
                }
                break;
            }
        }

        int rst = 0;
        while(i < str.length()) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') break;
            if (sign == 1 && (Integer.MAX_VALUE - (c-'0'))/10 < rst) return Integer.MAX_VALUE;
            if (sign == -1 && (Integer.MIN_VALUE + (c-'0'))/10 > -rst) return Integer.MIN_VALUE;
            rst = rst*10 + (c - '0');
            i++;
        }
        return rst*sign;
    }

    public static void main(String[] args) {
        String input = "1";
        _8_M_StringToIntegerATOI sol = new _8_M_StringToIntegerATOI();
        int rst = sol.myAtoi2(input);
        System.out.println(rst);
    }
}