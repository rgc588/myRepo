package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.ListNode;

/**
 * Created by cheng on 4/20/2017.
 */
public class _83_E_RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        Integer p = null;
        while(head != null) {
            if (p == null || p != head.val) {
                cur.next = head;
                cur = cur.next;
                p = head.val;
            }
            head = head.next;
        }
        cur.next = null;
        return dummy.next;
    }
}
