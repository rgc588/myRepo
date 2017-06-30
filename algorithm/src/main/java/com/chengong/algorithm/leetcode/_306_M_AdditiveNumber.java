package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/26/2017.
 */
public class _306_M_AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i <= num.length()/2; i++) {
            long n1 = Long.valueOf(num.substring(0,i));
            for (int j = 1; Math.max(i,j) + i + j <= num.length(); j++) {
                long n2 = Long.valueOf(num.substring(i,i+j));
                if (helper(num, n1, n2, i+j)) return true;
                if (n2 == 0) break;
            }
            if (n1 == 0) break;
        }
        return false;
    }

    private boolean helper(String num, long n1, long n2, int i) {
        if (i == num.length()) return true;
        String n = n1+n2+"";
        if (i + n.length() > num.length()) return false;
        if (num.substring(i,i+n.length()).equals(n)) {
            return helper(num, n2, n1+n2, i+n.length());
        }
        return false;
    }

    public static void main(String[] args) {
        String input = "112358";
        _306_M_AdditiveNumber sol = new _306_M_AdditiveNumber();
        System.out.print(sol.isAdditiveNumber(input));
    }
}
