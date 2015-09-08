package com.chengong.algorithm;

import java.util.Stack;

/**
 * Created by chengong on 9/8/15.
 */
public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();


    public void push(int x) {
        /**
         * initialize Integer(x) and use the same Integer
         * push(x) will create new instance each time
         */
        stack.push(x);
        if(min.isEmpty() || x <= min.peek()) {
            min.push(x);
        }
    }

    public void pop() {
        /**
         * can not use == here, if push two different Integer with same value
         */
        if(stack.peek().equals(min.peek())) {
            min.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        String command = "push(512),push(-1024),push(-1024),push(512),pop,getMin,pop,getMin,pop,getMin";

        String[] commands = command.split(",");

        for(String each : commands) {
            if(each.contains("push")) {
                minStack.push(Integer.valueOf(each.substring(5, each.length() - 1)));
            } else if(each.contains("pop")) {
                minStack.pop();
            } else if(each.contains("getMin")) {
                minStack.getMin();
            } else {
                throw new RuntimeException("Un-support operation");
            }
        }
    }
}
