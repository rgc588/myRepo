package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/15/2017.
 */
public class _223_M_RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int leftB = Math.max(A, E);
        int rightB = Math.min(C, G);
        int l = rightB <= leftB ? 0 : rightB-leftB;
        int upB = Math.min(D, H);
        int bottomB = Math.max(B, F);
        int h = upB <= bottomB ? 0 : upB - bottomB;
        return (C-A)*(D-B) - l*h + (H-F)*(G-E);
    }

    public static void main(String[] args) {
        String s = "abc  de";
        System.out.print(s);
        s = s.replaceAll("\\s", "");
        System.out.print(s);
    }
}
