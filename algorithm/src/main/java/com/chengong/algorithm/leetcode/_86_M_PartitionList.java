package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.ListNode;

/**
 * Created by cheng on 4/20/2017.
 */
public class _86_M_PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode cl = left;
        ListNode cr = right;
        while(head != null) {
            if (head.val < x) {
                cl.next = head;
                cl = head;
            } else {
                cr.next = head;
                cr = head;
            }
            head = head.next;
        }
        cl.next = right.next;
        cr.next = null;
        return left.next;
    }
}
