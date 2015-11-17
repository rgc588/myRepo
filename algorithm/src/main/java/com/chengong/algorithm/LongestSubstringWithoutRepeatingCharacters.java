package com.chengong.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chengong on 11/6/15.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()) return 0;
        int left = 0;
        int right = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while(right < s.length()) {
            char c = s.charAt(right);
            if(set.contains(c)) {
                while(s.charAt(left) != c) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            } else {
                set.add(c);
            }
            max = max > set.size() ? max : set.size();
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
        String input = "pwwkew";
        System.out.println(test.lengthOfLongestSubstring(input));
    }
}
