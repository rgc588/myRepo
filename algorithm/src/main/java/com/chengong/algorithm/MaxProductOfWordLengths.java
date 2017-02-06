package com.chengong.algorithm;

import java.util.*;

/**
 * Created by cheng on 8/10/2016.
 */
public class MaxProductOfWordLengths {
    public int maxProduct(String[] words) {
        List<Set<Character>> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            Set<Character> set = new HashSet<>();
            for (Character c : chars) {
                set.add(c);
            }
            list.add(set);
        }
        int rst = 0;
        Arrays.sort(words, new comp());
        for (int i = words.length - 1; i >= 0; i--) {
            if(words[i].length() * words[i].length() <= rst) break;
            for (int j = i - 1; j >= 0; j--) {
                boolean found = false;
                for (Character c = 'a'; c <= 'z'; c++) {
                    if (list.get(i).contains(c) && list.get(j).contains(c)){
                        found = true;
                        break;
                    }
                }
                if (!found) rst = Math.max(rst, words[i].length()*words[j].length());
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        String[] words = new String[] {"abc", "a", ""};
        MaxProductOfWordLengths solution = new MaxProductOfWordLengths();
        solution.maxProduct(words);
    }
}

class comp implements Comparator<String> {
    public int compare(String o1, String o2) {
        if (o1.length() > o2.length()) {
            return 1;
        } else if (o1.length() < o2.length()) {
            return -1;
        } else {
            return 0;
        }
    }
}