package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/26/2017.
 */
public class _125_E_ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length()-1;
        while(i<j) {
            if (isAlphanumeric(s.charAt(i)) && isAlphanumeric(s.charAt(j))) {
                if (s.charAt(i) == s.charAt(j)) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            } else {
                if (!isAlphanumeric(s.charAt(i))) {
                    i++;
                }
                if (!isAlphanumeric(s.charAt(j))) {
                    j--;
                }
            }
        }
        return true;
    }

    private boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
