package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.ListNode;

/**
 * Created by cheng on 4/19/2017.
 */
public class _61_M_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        int l = 0;
        while(cur != null && cur.next != null) {
            cur = cur.next;
            l++;
        }
        if (l == 0) return null;
        k = k%l;
        ListNode last = cur;
        if (k == 0) return head;
        k = l-k-1;
        cur = head;
        while(k > 0) {
            cur = cur.next;
            k--;
        }
        ListNode tmp = cur.next;
        cur.next = null;
        last.next = head;
        return tmp;
    }
}
