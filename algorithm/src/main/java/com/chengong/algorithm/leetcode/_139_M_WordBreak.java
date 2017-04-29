package com.chengong.algorithm.leetcode;

import java.util.List;

/**
 * Created by cheng on 4/28/2017.
 */
public class _139_M_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] mem = new boolean[s.length()+1];
        mem[0]=true;
        for (int i=0; i < s.length(); i++) {
            if (mem[i]) {
                for (int j = i+1; j <= s.length(); j++) {
                    if (wordDict.contains(s.substring(i,j))) {
                        mem[j] = true;
                    }
                }
            }
            if (mem[s.length()]) return true;
        }
        return mem[s.length()];
    }
}
