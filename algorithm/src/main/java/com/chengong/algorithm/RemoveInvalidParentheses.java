package com.chengong.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by cheng on 9/8/2016.
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        helper(s, 0, 0, sb, set);
        List<String> rst = new ArrayList<>();
        for (String ele: set) {
            rst.add(ele);
        }
        return rst;
    }

    private void helper(String s, int index, Integer count, StringBuilder sb, Set<String> set) {
        if (index >= s.length()) {
            if (count == 0) {
                if (set.isEmpty()) {
                    set.add(sb.toString());
                } else {
                    if ((new ArrayList<>(set)).get(0).length() > sb.length()) {
                        return;
                    } else if ((new ArrayList<>(set)).get(0).length() == sb.length()) {
                        set.add(sb.toString());
                    } else {
                        set.clear();
                        set.add(sb.toString());
                    }
                }
            }
            return;
        }
        char c = s.charAt(index);
        index++;
        if (c != '(' && c != ')') {
            sb.append(c);
            helper(s, index, count, sb, set);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            if (c == '(') {
                helper(s, index, count, sb, set);
                sb.append(c);
                helper(s, index, count + 1, sb, set);
                sb.deleteCharAt(sb.length() - 1);
            } else {
                if (count > 0) {
                    sb.append(c);
                    helper(s, index, count - 1, sb, set);
                    sb.deleteCharAt(sb.length() - 1);
                }
                helper(s, index, count, sb, set);
            }
        }
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses sol = new RemoveInvalidParentheses();
        String input = "()())()";
        List<String> rst = sol.removeInvalidParentheses(input);
        System.out.print(rst);
    }
}
