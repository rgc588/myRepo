package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cheng on 4/28/2017.
 */
public class _138_M_CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        RandomListNode pre = null;
        while(cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            if (pre != null) map.get(pre).next = map.get(cur);
            pre = cur;
            cur = cur.next;
        }
        cur = head;
        while(cur != null) {
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
