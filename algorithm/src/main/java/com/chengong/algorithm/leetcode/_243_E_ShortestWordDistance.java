package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/28/2017.
 */
public class _243_E_ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int lastIndex1 = -1;
        int lastIndex2 = -1;
        int min = words.length-1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                lastIndex1 = i;
                if (lastIndex2 != -1) {
                    min = Math.min(min, i-lastIndex2);
                }
            } else if (words[i].equals(word2)) {
                lastIndex2 = i;
                if (lastIndex1 != -1) {
                    min = Math.min(min, i-lastIndex1);
                }
            }
        }
        return min;
    }
}
