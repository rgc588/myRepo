package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.ListNode;

/**
 * Created by cheng on 4/20/2017.
 */
public class _82_M_RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(head != null) {
            if (head.next != null && head.val == head.next.val) {
                int val = head.val;
                while(head != null && head.val == val) {
                    head = head.next;
                }
            } else {
                cur.next = head;
                cur = cur.next;
                head = head.next;
            }
        }
        cur.next = null;
        return dummy.next;
    }
}
