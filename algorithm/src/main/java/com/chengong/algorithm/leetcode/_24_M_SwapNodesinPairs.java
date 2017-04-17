package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.ListNode;

/**
 * Created by cheng on 4/17/2017.
 */
public class _24_M_SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode c = dummy;
        while (c != null && c.next != null && c.next.next != null) {
            ListNode tmp = c.next;
            c.next = c.next.next;
            c = c.next;
            ListNode tmp2 = c.next;
            c.next = tmp;
            c = c.next;
            c.next = tmp2;
        }
        return dummy.next;
    }
}
