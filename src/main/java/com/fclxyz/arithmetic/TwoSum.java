package com.fclxyz.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * TwoSum
 * <p>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific
 * target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 *
 * @author tomclfan
 * @since  2019-01-29 16:00
 */
public class TwoSum {
    public static void main(String[] args) {
        int target = 15;
        int[] result = solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 33, 12}, target);
        System.out.println(result[0] + "," + result[1]);
    }

    private static int[] solution(int[] nums, final int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int target_num = target - num;
            if (numMap.get(target_num) != null) {
                return new int[]{i, numMap.get(target_num)};
            } else {
                numMap.put(num, i);
            }
        }

        throw new IllegalArgumentException("Two num not found!");
    }
}