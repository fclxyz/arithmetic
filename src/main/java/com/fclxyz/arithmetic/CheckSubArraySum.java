package com.fclxyz.arithmetic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [23,2,4,6,7], k = 6
 * 输出: True
 * 解释: [2,4] 是一个大小为 2 的子数组，并且和为 6。
 * 示例 2:
 * <p>
 * 输入: [23,2,6,4,7], k = 6
 * 输出: True
 * 解释: [23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
 * 说明:
 * <p>
 * 数组的长度不会超过10,000。
 * 你可以认为所有数字总和在 32 位有符号整数范围内。
 */
public class CheckSubArraySum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{23, 2, 5, 5, 7}, 6)));
    }

    private static int[] solution(int[] array, int k) {
        Map<Integer, Integer> modMap = new HashMap<>();
        int begin;
        int end;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            int mod = sum % k;
            if (modMap.get(mod) != null) {
                end = i;
                begin = modMap.get(mod);

                if (end > begin + 1) {
                    return Arrays.copyOfRange(array, begin + 1, end + 1);
                }
            } else {
                modMap.put(mod, i);
            }
        }

        return new int[]{};
    }
}
