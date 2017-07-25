package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 7/21/2017.
 */
public class _331_M_VerifyPreorderSerializationofaBinaryTree {
    int i = 0;
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.isEmpty()) return false;
        String[] nodes = preorder.split(",");
        return helper(nodes) && i == nodes.length-1;
    }

    private boolean helper(String[] input) {
        if (i >= input.length) return false;
        if (input[i].equals("#")) return true;
        i++;
        boolean left = helper(input);
        i++;
        boolean right = helper(input);
        return left && right;
    }

    public static void main(String[] args) {
        String input = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        _331_M_VerifyPreorderSerializationofaBinaryTree sol = new _331_M_VerifyPreorderSerializationofaBinaryTree();
        System.out.print(sol.isValidSerialization(input));
    }
}
