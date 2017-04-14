package com.chengong.algorithm.leetcode;


import com.chengong.algorithm.leetcode.BaseClasses.ListNode;

/**
 * Created by cheng on 2/6/2017.
 */
public class _2_M_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rst = new ListNode(-1);
        int carry = 0;
        ListNode cur = rst;
        while (l1 != null && l2 != null) {
            int value = l1.val + l2.val + carry;
            carry = value/10;
            value = value%10;
            cur.next = new ListNode(value);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode remain = l1;
        if (l2 != null) {
            remain = l2;
        }
        while (remain != null) {
            int value = remain.val + carry;
            carry = value/10;
            value = value%10;
            cur.next = new ListNode(value);
            cur = cur.next;
            remain = remain.next;
        }
        if (carry != 0) {
            cur.next = new ListNode(1);
        }
        return rst.next;
    }
}
