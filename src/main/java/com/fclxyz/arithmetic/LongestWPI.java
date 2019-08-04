package com.fclxyz.arithmetic;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 * <p>
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 * <p>
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 * <p>
 * 请你返回「表现良好时间段」的最大长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-well-performing-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 输入：hours = {9, 9, 6, 0, 6, 6, 9
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 */
public class LongestWPI {
    public static void main(String[] args) {
        int[] hours = {1, 8, 9, 9, 6, 9, 6, 6, 9};
        System.out.println(solution(hours, 8));
    }

    private static int solution(int[] hours, int key) {
        int length = hours.length;
        // 大于8小时计1分 小于等于8小时计 -1 分
        int[] score = new int[length];
        for (int i = 0; i < length; i++) {
            if (hours[i] > key) {
                score[i] = 1;
            } else {
                score[i] = -1;
            }
        }
        System.out.println(Arrays.toString(score));

        // 前缀和
        int[] presum = new int[length + 1];
        presum[0] = 0;

        for (int i = 0; i < length; i++) {
            presum[i + 1] = presum[i] + score[i];
        }

        System.out.println(Arrays.toString(presum));

        int ans = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length + 1; i++) {
            if (stack.isEmpty() || presum[stack.lastElement()] > presum[i]) {
                stack.add(i);
            }
        }
        // 顺序生成单调栈，栈中元素从第一个元素开始严格单调递减，最后一个元素肯定是数组中的最小元素所在位置
        // 倒序扫描数组，求最大长度坡
        int i = length;

        while (i > ans) {
            while (!stack.isEmpty() && presum[stack.lastElement()] < presum[i]) {
                ans = Math.max(ans, i - stack.lastElement());
                stack.pop();
            }
            i -= 1;
        }

        return ans;
    }


}
