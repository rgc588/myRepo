package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/2/2017.
 */
public class _151_M_ReverseWordsinaString {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length-1; i>= 0; i--) {
            String w = words[i];
            if (!w.isEmpty()) {
                sb.append(w);
                sb.append(" ");
            }
        }
        if (sb.length()!=0) sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }


}
