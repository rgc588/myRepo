package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/4/2017.
 */
public class _165_M_CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int index = 0;
        while(index < v1.length || index < v2.length) {
            int lv1 = 0;
            int lv2 = 0;
            if (index < v1.length) lv1 = Integer.valueOf(v1[index]);
            if (index < v2.length) lv2 = Integer.valueOf(v2[index]);
            if (lv1 < lv2) return -1;
            if (lv1 > lv2) return 1;
            index++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String v1 = "1";
        String v2 = "0";
        _165_M_CompareVersionNumbers sol = new _165_M_CompareVersionNumbers();
        sol.compareVersion(v1, v2);
    }
}
