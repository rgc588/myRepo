package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 7/11/2017.
 */
public class _393_M_UTF8Validation {
    public boolean validUtf8(int[] data) {
        int i = 0;
        int count = 0;
        int base = 128;
        while(i < data.length) {
            int d = data[i++];
            if ((d&base) != 0) {
                int c = 0;
                int b = base;
                while((b&d) != 0) {
                    c++;
                    if (c == 5) return false;
                    b /= 2;
                }
                if (c == 1) {
                    if (count == 0) return false;
                    count--;
                } else {
                    if (count != 0) return false;
                    count = c-1;
                }
            } else {
                if (count != 0) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] input = new int[] {197,130,1};
        _393_M_UTF8Validation sol = new _393_M_UTF8Validation();
        sol.validUtf8(input);
    }
}
