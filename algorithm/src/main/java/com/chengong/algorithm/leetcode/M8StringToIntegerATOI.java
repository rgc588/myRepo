package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 2/16/2017.
 */
public class M8StringToIntegerATOI {
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

    public static void main(String[] args) {
        String input = "-1";
        M8StringToIntegerATOI sol = new M8StringToIntegerATOI();
        int rst = sol.myAtoi(input);
        System.out.println(rst);
    }
}