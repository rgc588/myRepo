package com.chengong.algorithm.leetcode;

import java.util.*;

/**
 * Created by cheng on 4/26/2017.
 */
public class _127_M_WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String each : wordList) {
            dict.add(each);
        }
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int count = 0;
        while(!q.isEmpty()) {
            Queue<String> tmp = new LinkedList<>();
            while(!q.isEmpty()) {
                String word = q.remove();
                if (word.equals(endWord)) return count+1;
                for (int i = 0; i < word.length(); i++) {
                    StringBuilder sb = new StringBuilder(word);
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != sb.charAt(i)) {
                            sb.setCharAt(i,c);
                            String newWord = sb.toString();
                            if (dict.contains(newWord)) {
                                tmp.add(newWord);
                                dict.remove(newWord);
                            }
                        }
                    }
                }
            }
            q = tmp;
            count++;
        }
        return 0;
    }
}
