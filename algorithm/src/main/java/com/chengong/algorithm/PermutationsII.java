package com.chengong.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chengong on 9/18/15.
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        rst.add(new ArrayList<Integer>());
        if(nums == null || nums.length == 0) return rst;
        rst.get(0).add(nums[0]);

        int index = 1;
        while(index < nums.length) {
            Set<List<Integer>> set = new HashSet<>();
            for(List<Integer> each : rst) {
                int i = 0;
                while(i <= each.size()) {
                    each.add(i, nums[index]);
                    set.add(new ArrayList<>(each));
                    each.remove(i);
                    i++;
                }
            }
            index++;
            rst = new ArrayList<>(set);
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] input = new int[] {1,2};
        System.out.println(new PermutationsII().permuteUnique(input));
    }
}
