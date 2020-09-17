package com.fclxyz.arithmetic.jzoffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class Test004 {
    public static List<Integer> printListFromTailToHead(List<Integer> list) {
        List<Integer> result = new LinkedList<>();

        if (list == null || list.size() == 0) {
            return null;
        }

        for (int i = 0; i < list.size(); i++) {
            result.add(list.get(list.size() - 1 - i));
        }


        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(printListFromTailToHead(list));
    }
}
