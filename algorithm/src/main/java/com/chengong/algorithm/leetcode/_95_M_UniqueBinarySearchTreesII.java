package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 4/24/2017.
 */
public class _95_M_UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return helper(1, n);
    }

    private List<TreeNode> helper(int left, int right) {
        List<TreeNode> rst = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            List<TreeNode> lefts = helper(left, i-1);
            List<TreeNode> rights = helper(i+1, right);
            for (TreeNode l : lefts) {
                for (TreeNode r : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    rst.add(root);
                }
            }
        }
        if (rst.size() == 0) rst.add(null);
        return rst;
    }
}
