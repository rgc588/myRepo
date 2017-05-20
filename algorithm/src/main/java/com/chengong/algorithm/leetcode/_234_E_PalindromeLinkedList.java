package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.ListNode;

/**
 * Created by cheng on 5/18/2017.
 */
public class _234_E_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode dummy = new ListNode(0);
        while(slow != null) {
            ListNode tmp = slow.next;
            slow.next = dummy.next;
            dummy.next = slow;
            slow = tmp;
        }
        dummy = dummy.next;
        while(dummy != null && head != null) {
            if (dummy.val != head.val) return false;
            dummy=dummy.next;
            head=head.next;
        }
        return true;
    }
}
