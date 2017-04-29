package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.ListNode;

/**
 * Created by cheng on 4/28/2017.
 */
public class _142_M_LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow != fast) return null;
        slow = head;
        fast = fast.next;
        while(fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
