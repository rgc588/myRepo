package com.chengong.algorithm.leetcode;

import java.util.Stack;

/**
 * Created by cheng on 5/18/2017.
 */
public class _232_E_ImplementQueueusingStacks {
    Stack<Integer> s = new Stack<>();
    Stack<Integer> q = new Stack<>();
    /** Initialize your data structure here. */
    public _232_E_ImplementQueueusingStacks() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return q.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(q.isEmpty()) {
            while(!s.isEmpty()) {
                q.add(s.pop());
            }
        }
        return q.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s.isEmpty() && q.isEmpty();
    }
}
