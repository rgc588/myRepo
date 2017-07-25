package com.chengong.algorithm.leetcode;


import java.util.Stack;

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

    public int calculate2(String s) {
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i < s.length()) {
            char c = s.charAt(i);
            if (isNumber(c)) {
                num = num*10 + (c-'0');
            }
            if ((!isNumber(c) && c != ' ') || i == s.length()-1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop()*num);
                } else {
                    stack.push(stack.pop()/num);
                }
                num = 0;
                sign = c;
            }
            i++;
        }
        int rst = 0;
        while(!stack.isEmpty()) {
            rst += stack.pop();
        }
        return rst;
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        String input = "42";
        _227_M_BasicCalculatorII sol = new _227_M_BasicCalculatorII();
        System.out.println(sol.calculate(input));
    }
}
