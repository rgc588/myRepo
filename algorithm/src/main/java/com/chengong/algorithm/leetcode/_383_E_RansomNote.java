package com.chengong.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cheng on 4/12/2017.
 */
public class _383_E_RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine == null) return false;
        if (ransomNote == null) return true;
        if (ransomNote.length() > magazine.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < magazine.length(); i++) {
            if (map.isEmpty()) return true;
            char c = magazine.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                if (count == 1) {
                    map.remove(c);
                } else {
                    map.put(c, count-1);
                }
            }
        }
        return map.isEmpty();
    }

    /**
     * 26 letter, so can use int[] instead of map
     */
    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
