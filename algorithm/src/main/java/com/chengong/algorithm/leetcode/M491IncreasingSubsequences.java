package com.chengong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cheng on 3/20/2017.
 */
public class M491IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        Map<Integer, List<List<Integer>>> last = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                List<List<Integer>> tmp = new ArrayList<>();
                for (List<Integer> l : last.get(nums[i])){
                    List<Integer> nl = new ArrayList<>();
                    nl.addAll(l);
                    nl.add(nums[i]);
                    tmp.add(nl);
                }
                map.get(nums[i]).addAll(tmp);
                last.put(nums[i], tmp);
            } else {
                List<List<Integer>> tmp = new ArrayList<>();
                for (Integer key : map.keySet()) {
                    if (key <= nums[i]) {
                        List<Integer> l = new ArrayList<>();
                        l.add(key);
                        l.add(nums[i]);
                        tmp.add(l);
                        for (List<Integer> each : map.get(key)) {
                            List<Integer> t = new ArrayList<>();
                            t.addAll(each);
                            t.add(nums[i]);
                            tmp.add(t);
                        }
                    }
                }
                map.put(nums[i], tmp);
                List<List<Integer>> lastList = new ArrayList<>();
                for (List<Integer> each : tmp) {
                    List<Integer> nl = new ArrayList<>();
                    nl.addAll(each);
                    lastList.add(nl);
                }
                List<Integer> self = new ArrayList<>();
                self.add(nums[i]);
                lastList.add(self);
                last.put(nums[i], lastList);
            }
        }
        for (List<List<Integer>> v : map.values()) {
            rst.addAll(v);
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] input = new int[] {4,6,7,7};
        M491IncreasingSubsequences sol = new M491IncreasingSubsequences();
        List<List<Integer>> rst = sol.findSubsequences(input);
        System.out.println(rst);
    }
}
