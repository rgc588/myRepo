package com.chengong.algorithm;

import java.util.Stack;

/**
 * Created by chengong on 11/13/15.
 */
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sHelper(root, sb);
        return sb.toString();
    }

    private void sHelper(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        sHelper(root.left, sb);
        sHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty() || data.charAt(0) == '#') return null;
        String[] strs = data.split(",");
        int index = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = new TreeNode(Integer.valueOf(strs[index++]));
        TreeNode root = cur;
        while(!stack.isEmpty() || cur != null) {
            if(cur != null) {
                String s = strs[index++];
                if(!s.equals("#")) cur.left = new TreeNode(Integer.valueOf(s));
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode n = stack.pop();
                String s = strs[index++];
                if(!s.equals("#")) n.right = new TreeNode(Integer.valueOf(s));
                cur = n.right;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree test = new SerializeAndDeserializeBinaryTree();
        TreeNode n = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        n.left = l;
        String saved = test.serialize(n);
        TreeNode rst = test.deserialize(saved);
    }
}
