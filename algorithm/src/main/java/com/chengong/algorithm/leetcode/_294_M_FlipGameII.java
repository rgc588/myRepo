package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 7/23/2017.
 */
public class _294_M_FlipGameII {
    public boolean canWin(String s) {
        char[] str = s.toCharArray();
        return helper(str);
    }

    private boolean helper(char[] str) {
        for (int i = 0; i < str.length-1; i++) {
            if (str[i] == '+' && str[i+1] == '+') {
                str[i] = '-';
                str[i+1] = '-';
                if (!helper(str)) return true;
                str[i] = '+';
                str[i+1] = '+';
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String input = "++++";
        _294_M_FlipGameII sol = new _294_M_FlipGameII();
        System.out.print(sol.canWin(input));
    }
}
