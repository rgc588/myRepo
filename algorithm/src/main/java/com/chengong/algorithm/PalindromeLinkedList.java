package com.chengong.algorithm;

/**
 * Created by chengong on 10/29/15.
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode(-1);

        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        while(fast != null && fast.next != null) {
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode right = new ListNode(-1);
        ListNode cur = slow.next;
        while(cur != null) {
            ListNode next = right.next;
            right.next = cur;
            ListNode nextCur = cur.next;
            cur.next = next;
            cur = nextCur;
        }
        right = right.next;

        ListNode left = dummy.next;

        while(right != null) {
            if(left.val != right.val) return false;
            right = right.next;
            left = left.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode input = new ListNode(1);
        ListNode second = new ListNode(2);
        input.next= second;

        PalindromeLinkedList test = new PalindromeLinkedList();
        System.out.println(test.isPalindrome(input));
    }
}
