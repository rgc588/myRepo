package com.chengong.algorithm.leetcode.BaseClasses;

/**
 * Created by cheng on 4/3/2017.
 */
public class E9PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x!=0 && x%10==0)) return false;
        int y = 0;
        while(x > y) {
            y = y*10 + x%10;
            x = x/10;
        }
        return x == y || y/10 == x;
    }

    //overflow
    //corner case: negative numbers
    public boolean isPalindrome2(int x) {
        if (x < 0) return false;
        long xx = x;
        long y = 0;
        while(x > 0) {
            y = y*10 + x%10;
            x = x/10;
        }
        return xx  == y;
    }
}
