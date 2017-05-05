package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.ListNode;

/**
 * Created by cheng on 4/29/2017.
 */
public class _143_M_ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode last = slow.next;
        while(last.next != null) {
            ListNode first = last.next;
            last.next = first.next;
            first.next = slow.next;
            slow.next = first;
        }
        while(head != slow && slow.next != null) {
            ListNode n = slow.next;
            slow.next = n.next;
            n.next = head.next;
            head.next = n;
            head = n.next;
        }
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        one.next = two;
        two.next = three;
        three.next = four;
        _143_M_ReorderList sol = new _143_M_ReorderList();
        sol.reorderList(one);
        while(one!=null) {
            System.out.print(one.val);
            one = one.next;
        }
    }
}
