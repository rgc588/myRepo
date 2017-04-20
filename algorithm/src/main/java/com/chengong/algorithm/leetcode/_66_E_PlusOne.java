package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/19/2017.
 */
public class _66_E_PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return null;
        int index = digits.length-1;
        while(index>=0) {
            if (digits[index] == 9) {
                digits[index--] = 0;
            } else {
                digits[index] +=1;
                break;
            }
        }
        if (index >= 0) return digits;
        int[] rst = new int[digits.length+1];
        rst[0] = 1;
        return rst;
    }
}
