package com.chengong.algorithm;

/**
 * Created by cheng on 9/7/2016.
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        boolean[] match = new boolean[s.length() + 1];
        match[0] = true;
        int index = 0;
        while(index < p.length()) {
            boolean[] newMatch = new boolean[s.length() + 1];
            char c = p.charAt(index);
            if (index < p.length() - 1 && p.charAt(index + 1) == '*') {
                index++;
                for (int i = 0; i < newMatch.length; i++) {
                    if (match[i]) newMatch[i] = true;
                    if (c == '.' && match[i]) {
                        for (int j = i; j < newMatch.length; j++) {
                            newMatch[j] = true;
                        }
                        break;
                    }
                    if (i > 0 && (c == s.charAt(i - 1)) && match[i - 1]) {
                        newMatch[i] = true;
                    }
                    if (i > 1 && newMatch[i - 1] && c == s.charAt(i - 1) && s.charAt(i - 1) == s.charAt(i - 2)) {
                        newMatch[i] = true;
                    }
                }
            } else {
                for (int i = 1; i < newMatch.length; i++) {
                    if ((c == '.' || c == s.charAt(i - 1)) && match[i - 1]) {
                        newMatch[i] = true;
                    }
                }
            }
            index++;
            match = newMatch;
        }
        return match[match.length - 1];
    }

    public static void main(String[] args) {
        RegularExpressionMatching sol = new RegularExpressionMatching();
        boolean isMatching = sol.isMatch("aab", "b.*");
        System.out.println(isMatching);
    }
}
