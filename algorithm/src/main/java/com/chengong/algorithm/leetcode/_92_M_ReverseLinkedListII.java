package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.ListNode;

/**
 * Created by cheng on 4/21/2017.
 */
public class _92_M_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        int length = n-m+1;
        ListNode dummy1 = new ListNode(0);
        dummy1.next = head;
        ListNode cur = dummy1;
        while(cur != null && m-1>0) {
            cur = cur.next;
            m--;
        }
        ListNode leftEnd = cur;
        ListNode dummy2 = new ListNode(0);
        cur = cur.next;
        ListNode midEnd = cur;
        while(cur !=null && length>0) {
            ListNode tmp = dummy2.next;
            dummy2.next = cur;
            ListNode next = cur.next;
            cur.next = tmp;
            cur = next;
            length--;
        }
        leftEnd.next = dummy2.next;
        if (midEnd != null) midEnd.next = cur;
        return dummy1.next;
    }
}
