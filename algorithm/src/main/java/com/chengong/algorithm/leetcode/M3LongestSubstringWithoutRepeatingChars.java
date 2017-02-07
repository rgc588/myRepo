package com.chengong.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cheng on 2/6/2017.
 */
public class M3LongestSubstringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int cur = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && cur < map.get(c)) {
                cur = map.get(c);
            }
            max = max > i - cur ? max : i - cur;
            map.put(c, i);
        }
        return max;
    }
}
