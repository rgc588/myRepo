package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 3/3/2017.
 */
public class _504_E_Base7 {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        String sign = "";
        if (num < 0) {
            sign = "-";
            num = -1*num;
        }
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            sb.insert(0, String.valueOf(num%7));
            num /= 7;
        }
        sb.insert(0, sign);
        return sb.toString();
    }
}
