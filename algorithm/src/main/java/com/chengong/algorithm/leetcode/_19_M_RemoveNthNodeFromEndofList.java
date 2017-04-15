package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.ListNode;

/**
 * Created by cheng on 4/14/2017.
 */
public class _19_M_RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) return head;
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        while(n>=0 && fast!=null) {
            fast = fast.next;
            n--;
        }
        if (n>=0) return head;
        ListNode slow = dummy;
        while(fast!=null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
