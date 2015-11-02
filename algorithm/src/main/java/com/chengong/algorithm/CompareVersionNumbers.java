package com.chengong.algorithm;

/**
 * Created by chengong on 11/1/15.
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");//this method take pattern, don't forget to escape special character
        String[] v2 = version2.split("\\.");

        int index1 = 0;
        int index2 = 0;
        while(index1 < v1.length || index2 < v2.length) {
            int vn1 = 0;
            int vn2 = 0;
            if(index1 < v1.length) vn1 = Integer.valueOf(v1[index1]);
            if(index2 < v2.length) vn2 = Integer.valueOf(v2[index2]);
            if(vn1 == vn2) {
                index1++;
                index2++;
            } else {
                return vn1 > vn2 ? 1 : -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersionNumbers test = new CompareVersionNumbers();
        String str1 = "0";
        String str2 = "1";

        System.out.println(test.compareVersion(str1, str2));
    }
}
