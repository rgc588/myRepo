package com.chengong.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by cheng on 4/11/2017.
 */
public class M482LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        Queue<Character> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
                q.add(c);
                count++;
            } else if (c >= 'a' && c <= 'z') {
                c = (char)(c + (char)('A' - 'a'));
                q.add(c);
                count++;
            }
        }
        count = count%K;
        StringBuilder sb = new StringBuilder();
        for (int i =0; i < count; i++) {
            sb.append(q.remove());
        }
        while (!q.isEmpty()) {
            sb.append('-');
            for (int i = 0; i < K; i++) {
                sb.append(q.remove());
            }
        }
        if(sb.length()>0 && sb.charAt(0) == '-') sb.deleteCharAt(0);
        return sb.toString();
    }
}
