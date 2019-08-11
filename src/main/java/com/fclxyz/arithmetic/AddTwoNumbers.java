package com.fclxyz.arithmetic;

import java.util.*;

/**
 * Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * @author tomclfan
 * @since 2019-01-29 16:00
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        List<Integer> first = new LinkedList<>();
        first.add(2);
        first.add(4);
        first.add(6);

        List<Integer> second = new LinkedList<>();
        second.add(3);
        second.add(6);
        second.add(9);

        List<Integer> result = solution(first, second);
        System.out.println(result);
    }

    private static List<Integer> solution(List<Integer> first, List<Integer> second) {
        List<Integer> result = new LinkedList<>();
        int firstLength = first.size();
        int secondlength = second.size();
        int aaxLength = Math.max(firstLength, secondlength);

        Iterator<Integer> firstIterator = first.iterator();
        Iterator<Integer> secondIterator = second.iterator();

        boolean moreThanTen = false;
        for (int i = 0; i <= aaxLength; i++) {
            int resultInt;
            int firstInt = 0;
            int secondInt = 0;
            int addition = 0;

            if (firstIterator.hasNext()) {
                firstInt = firstIterator.next();
            }
            if (secondIterator.hasNext()) {
                secondInt = secondIterator.next();
            }
            if (moreThanTen) {
                addition = 1;
            }

            resultInt = firstInt + secondInt + addition;

            if (resultInt >= 10) {
                moreThanTen = true;
                result.add(resultInt - 10);
            } else {
                result.add(resultInt);
                moreThanTen = false;
            }
        }

        return result;
    }
}