package com.chengong.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by cheng on 4/19/2017.
 */
public class _71_M_SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        for (String f : path.split("/")) {
            if (!f.isEmpty()) {
                if (f.equals("..")) {
                    if (!stack.isEmpty()) stack.pop();
                } else {
                    if (!f.equals(".")) stack.push(f);
                }
            }
        }
        String res = "";
        for (String dir : stack) res = "/" + dir + res;
        return res.isEmpty() ? "/" : res;
    }

    public static void main(String[] args) {
        String input = "/...";
        _71_M_SimplifyPath sol = new _71_M_SimplifyPath();
        System.out.print(sol.simplifyPath(input));
    }
}
