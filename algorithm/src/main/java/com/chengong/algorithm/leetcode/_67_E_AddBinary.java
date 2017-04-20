package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/19/2017.
 */
public class _67_E_AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int c = 0;
        while(i >=0 || j >= 0 || c != 0) {
            int va = i >= 0 ? (a.charAt(i--) == '1' ? 1 : 0) : 0;
            int vb = j >= 0 ? (b.charAt(j--) == '1' ? 1 : 0) : 0;
            int sum = va+vb+c;
            sb.insert(0,sum%2);
            c = sum/2;
        }
        return sb.toString();
    }
}
