package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 7/10/2017.
 */
public class _395_M_LongestSubstringwithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        int max = 0;
        if (k > s.length()) return max;
        int[] mem = new int[256];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            mem[c]++;
            if (mem[c] == k) count += k;
            if (mem[c] > k) count += 1;
        }
        if (count == s.length()) return count;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (mem[c] < k) {
                for (String str : s.split(c+"")) {
                    max = Math.max(max, longestSubstring(str, k));
                }
                break;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String input = "bbaaacbd";
        _395_M_LongestSubstringwithAtLeastKRepeatingCharacters sol = new _395_M_LongestSubstringwithAtLeastKRepeatingCharacters();
        System.out.println(sol.longestSubstring(input, 3));
    }
}
