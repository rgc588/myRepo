package com.chengong.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cheng on 4/20/2017.
 */
public class _76_H_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        int count = t.length();
        int left = 0;
        int right = 0;
        int index = -1;
        int min = Integer.MAX_VALUE;
        if (count == 0) return "";
        while(right < s.length() || (count == 0 && left < right)) {
            if (count == 0) {
                if (right - left < min) {
                    min = right - left;
                    index = left;
                }
                char c = s.charAt(left);
                if (map.containsKey(c)) {
                    int require = map.get(c);
                    map.put(c, ++require);
                    if (require > 0) count++;
                }
                left++;
            } else {
                char c = s.charAt(right);
                if (map.containsKey(c)) {
                    int require = map.get(c);
                    map.put(c, require-1);
                    if (require > 0) count--;
                }
                right++;
            }
        }
        return index == -1 ? "" : s.substring(index, index+min);
    }

    public static void main(String[] args) {
        String s = "a";
        String t = "a";
        _76_H_MinimumWindowSubstring sol = new _76_H_MinimumWindowSubstring();
        System.out.print(sol.minWindow(s, t));
    }
}
