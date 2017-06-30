package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 6/19/2017.
 */
public class _307_M_RangeSumQueryMutable {
    int[] tree;
    int[] nums;
    public _307_M_RangeSumQueryMutable(int[] nums) {
        this.tree = new int[nums.length*2];
        this.nums = nums;
        buildTree(nums, 0, nums.length-1, tree, 0);
    }

    private int buildTree(int[] nums, int i, int j, int[] tree, int index) {
        if (i == j) {
            tree[index] = nums[i];
        } else {
            int mid = (i+j)/2;
            int left = buildTree(nums, i, mid, tree, index*2+1);
            int right = buildTree(nums, mid+1, j, tree, index*2+2);
            tree[index] = left + right;
        }
        return tree[index];
    }

    public void update(int i, int val) {
        int diff = val - nums[i];
        updateTree(i, diff, tree, 0, 0, nums.length-1);
        nums[i] = val;
    }

    private void updateTree(int i, int diff, int[] tree, int index, int s, int e) {
        tree[index] += diff;
        if (s == e) return;
        int mid = (s+e)/2;
        if (i <= mid) {
            updateTree(i, diff, tree, index*2+1, s, mid);
        } else {
            updateTree(i, diff, tree, index*2+2, mid+1, e);
        }
    }

    public int sumRange(int i, int j) {
        return searchTree(i, j, tree, 0, 0, nums.length-1);
    }

    private int searchTree(int i, int j, int[] tree, int index, int s, int e) {
        if (j < s || i > e) {
            return -1;
        } else if (i <= s && j >= e) {
            return tree[index];
        } else {
            int mid = (s+e)/2;
            int left = searchTree(i, j, tree, index*2+1, s, mid);
            int right = searchTree(i, j, tree, index*2+2, mid+1, e);
            if (left == -1) left = 0;
            if (right == -1) right = 0;
            return left + right;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[] {1,3,5};
        _307_M_RangeSumQueryMutable sol = new _307_M_RangeSumQueryMutable(input);
        System.out.print(sol.sumRange(0,2));
        sol.update(1,2);
        System.out.print(sol.sumRange(0,2));
    }
}
