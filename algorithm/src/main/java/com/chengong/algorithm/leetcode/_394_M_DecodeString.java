package com.chengong.algorithm.leetcode;

import java.util.Stack;

/**
 * Created by cheng on 6/13/2017.
 */
public class _394_M_DecodeString {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<String> prefix = new Stack<>();
        Stack<Integer> repeat = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            while(Character.isDigit(s.charAt(i))) {
                count = count*10+Character.getNumericValue(s.charAt(i));
                i++;
            }
            if (count == 0) {
                if(s.charAt(i) == ']') {
                    int r = repeat.pop();
                    String str = sb.toString();
                    sb = new StringBuilder();
                    sb.append(prefix.pop());
                    while(r-- > 0) {
                        sb.append(str);
                    }
                } else {
                    sb.append(s.charAt(i));
                }
            } else {
                repeat.add(count);
                prefix.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "100[leetcode]";
        _394_M_DecodeString sol = new _394_M_DecodeString();
        System.out.print(sol.decodeString(input));
    }
}
