package com.chengong.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by cheng on 5/6/2017.
 */
public class _179_M_LargestNumber {
    public String largestNumber(int[] nums) {
        String[] numstrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numstrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numstrs, new MyComparator());
        if(numstrs[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numstrs.length; i++) {
            sb.append(numstrs[i]);
        }
        return sb.toString();
    }

    class MyComparator implements Comparator<String> {
        public int compare(String l, String r) {
            return (r+l).compareTo(l+r);
        }
    }
}
