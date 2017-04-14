package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/3/2017.
 */
public class _14_E_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs==null || strs.length==0) return "";
        String prefix = strs[0];
        for (String s : strs) {
            while(s.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;
    }
}
