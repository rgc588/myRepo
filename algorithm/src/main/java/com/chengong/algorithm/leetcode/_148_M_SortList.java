package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.ListNode;

/**
 * Created by cheng on 5/2/2017.
 */
public class _148_M_SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode s = head;
        ListNode f = head;
        while(f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        ListNode tmp = s.next;
        s.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode dummy = new ListNode(0);
        tmp = dummy;
        while(left != null || right != null) {
            if (left == null || (right != null && left.val > right.val)) {
                tmp.next = right;
                tmp = right;
                right = right.next;
            } else {
                tmp.next = left;
                tmp = left;
                left = left.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(1);
        first.next = second;
        _148_M_SortList sol = new _148_M_SortList();
        sol.sortList(first);
    }
}
