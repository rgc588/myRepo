package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 6/23/2017.
 */
public class _28_E_ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        int[] lsp = new int[needle.length()];
        buildLSP(needle, lsp);
        int i = 0;
        int j = 0;
        while(i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length()) {
                    return i-j;
                }
            } else if (j == 0) {
                i++;
            } else {
                j = lsp[j-1];
            }
        }
        return -1;
    }

    private void buildLSP(String s, int[] lsp) {
        int cur = 0;
        int i = 1;
        while(i < lsp.length) {
            if (s.charAt(i) == s.charAt(cur)) {
                lsp[i++] = ++cur;
            } else if (cur == 0){
                lsp[i++] = 0;
            } else {
                cur = lsp[cur-1];
            }
        }
    }

    public static void main(String[] args) {
        String a = "aabaaabaaac";
        String b = "aabaaac";
        _28_E_ImplementstrStr sol = new _28_E_ImplementstrStr();
        System.out.print(sol.strStr(a, b));
    }
}
