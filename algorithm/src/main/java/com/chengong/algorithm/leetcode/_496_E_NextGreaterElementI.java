package com.chengong.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by cheng on 3/10/2017.
 */
public class _496_E_NextGreaterElementI {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack<Integer> s = new Stack<>();
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            while (!s.isEmpty() && s.peek() < nums[i]) {
                m.put(s.pop(), nums[i]);
            }
            s.push(nums[i]);
        }
        int[] rst = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++) {
            if (m.containsKey(findNums[i])) {
                rst[i] = m.get(findNums[i]);
            } else {
                rst[i] = -1;
            }
        }
        return rst;
    }

    public int[] nextGreaterElement2(int[] findNums, int[] nums) {
        int[] ret = new int[findNums.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = nums.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) map.put(nums[i], -1);
            else map.put(nums[i], stack.peek());
            stack.push(nums[i]);
        }
        for(int i = 0; i < findNums.length; i++) {
            ret[i] = map.get(findNums[i]);
        }
        return ret;
    }
}
