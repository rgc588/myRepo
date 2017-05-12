package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.ListNode;

/**
 * Created by cheng on 5/2/2017.
 */
public class _147_M_InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        while(head != null) {
            ListNode cur = dummy;
            while(cur.next != null && cur.next.val < head.val) {
                cur = cur.next;
            }
            ListNode n = head;
            head = head.next;
            n.next = cur.next;
            cur.next = n;
        }
        return dummy.next;
    }
}
