package com.fclxyz.arithmetic.jzoffer;

import java.util.Stack;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class Test007 {
    Stack<Integer> in = new Stack<Integer>();
    Stack<Integer> out = new Stack<Integer>();

    public void push(int node) {
        in.push(node);
    }

    public int pop() throws Exception {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }

        if (!out.isEmpty()) {
            return out.pop();
        } else {
            throw new Exception("queue is empty");
        }
    }


    public static void main(String[] args) throws Exception {
        Test007 test007 = new Test007();
        test007.push(1);
        test007.push(2);
        test007.push(3);
        test007.push(4);

        System.out.println(test007.pop());
        System.out.println(test007.pop());
        System.out.println(test007.pop());
        System.out.println(test007.pop());
        System.out.println(test007.pop());
    }
}
