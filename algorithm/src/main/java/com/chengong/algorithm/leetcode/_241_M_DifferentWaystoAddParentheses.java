package com.chengong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cheng on 5/20/2017.
 */
public class _241_M_DifferentWaystoAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> rst = helper(input, map);
        return rst;
    }

    private List<Integer> helper(String input, Map<String, List<Integer>> map) {
        if (map.containsKey(input)) {
            return map.get(input);
        }
        List<Integer> rst = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = helper(input.substring(0, i), map);
                List<Integer> right = helper(input.substring(i+1, input.length()), map);
                for (int l : left) {
                    for (int r : right) {
                        if(c == '+'){
                            rst.add(l+r);
                        } else if (c == '-') {
                            rst.add(l-r);
                        } else {
                            rst.add(l*r);
                        }
                    }
                }
            }
        }
        if(rst.isEmpty()) {
            rst.add(Integer.valueOf(input));
        }
        map.put(input,rst);
        return rst;
    }
}
