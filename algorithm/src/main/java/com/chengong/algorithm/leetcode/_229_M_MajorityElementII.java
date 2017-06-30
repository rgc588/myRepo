package com.chengong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 5/16/2017.
 */
public class _229_M_MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> rst = new ArrayList<>();
        if (nums == null) return rst;
        int n1 = 0;
        int n2 = 0;
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (c1 != 0 && n1 == nums[i]) {
                c1++;
            } else if (c2 != 0 && n2 == nums[i]) {
                c2++;
            } else if (c1 == 0) {
                n1 = nums[i];
                c1++;
            } else if (c2 == 0) {
                n2 = nums[i];
                c2++;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = count(nums, n1);
        c2 = count(nums, n2);
        if (c1 > nums.length/3) rst.add(n1);
        if (n1 != n2 && c2 > nums.length/3) rst.add(n2);
        return rst;
    }

    private int count(int[] nums, int n) {
        int c = 0;
        for (int e : nums) {
            if(e==n) c++;
        }
        return c;
    }

    public static void main(String[] args) {
        int[] input = new int[] {1,2};
        _229_M_MajorityElementII sol = new _229_M_MajorityElementII();
        sol.majorityElement(input);
    }
}
