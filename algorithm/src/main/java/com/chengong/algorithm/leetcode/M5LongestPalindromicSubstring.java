package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 2/6/2017.
 */
public class M5LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        boolean[] cache = new boolean[s.length()];
        int start = 0;
        int end = 0;
        cache[0] = true;
        for (int i = 1; i < s.length(); i++) {
            boolean[] temp = new boolean[s.length()];
            temp[i] = true;
            if (s.charAt(i) == s.charAt(i - 1)) {
                temp[i-1] = true;
                if (end - start < 1) {
                    start = i-1;
                    end = i;
                }
            }
            for (int j = 1; j < i; j++) {
                if (cache[j] && s.charAt(j-1) == s.charAt(i)) {
                    temp[j-1] = true;
                    if (end - start < i - (j-1)) {
                        start = j-1;
                        end = i;
                    }
                }
            }
            cache = temp;
        }
        return s.substring(start,end+1);
    }

    public static void main(String[] args) {
        M5LongestPalindromicSubstring sol = new M5LongestPalindromicSubstring();
        String input = "abcba";
        String output = sol.longestPalindrome(input);
        System.out.println(output.equals("abcba"));
    }
}
