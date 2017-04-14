package com.chengong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 4/3/2017.
 */
public class _17_M_LetterCombinationsofaPhoneNumber {
    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> rst = new ArrayList<>();
        if (digits == null || digits.length() == 0) return rst;
        helper(0, "", digits, rst);
        return rst;
    }

    private void helper(int index, String current, String digits, List<String> rst) {
        if (index >= digits.length()) {
            rst.add(current);
            return;
        }
        for (char c : mapping[Character.getNumericValue(digits.charAt(index))].toCharArray()) {
            helper(index+1, current+c, digits, rst);
        }
    }
}
