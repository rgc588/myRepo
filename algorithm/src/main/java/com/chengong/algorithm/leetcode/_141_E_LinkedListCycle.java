package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.ListNode;

/**
 * Created by cheng on 4/28/2017.
 */
public class _141_E_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow == fast;
    }
}
