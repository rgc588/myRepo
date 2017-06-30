package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/16/2017.
 */
public class _227_M_BasicCalculatorII {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        int index = 0;
        int sum = 0;
        int sign = 1;
        while(index < s.length()){
            char c = s.charAt(index);
            if (c == '-' || c == '+') {
                sign = c == '+' ? 1 : -1;
                index++;
                continue;
            }
            int num = 0;
            int mult = 1;
            while(index < s.length() && s.charAt(index) != '+' && s.charAt(index) != '-') {
                if (s.charAt(index) == '*') {
                    mult *= num;
                    num = 0;
                } else if (s.charAt(index) == '/') {
                    if (num == 0) {
                        mult = 0;
                    } else {
                        mult /= num;
                    }
                    num = 0;
                } else {
                    num = num*10 + (s.charAt(index)-'0');
                }
                index++;
            }
            mult *= num;
            sum += sign*mult;
        }
        return sum;
    }

    public static void main(String[] args) {
        String input = "1/2";
        _227_M_BasicCalculatorII sol = new _227_M_BasicCalculatorII();
        System.out.print(sol.calculate(input));
    }
}
