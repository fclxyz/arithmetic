package com.fclxyz.arithmetic;

import java.util.Arrays;

/**
 * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择 x = -K 或是 x = K，并将 x 加到 A[i] 中。
 * <p>
 * 在此过程之后，我们得到一些数组 B。
 * <p>
 * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1], K = 0
 * 输出：0
 * 解释：B = [1]
 * 示例 2：
 * <p>
 * 输入：A = [0,10], K = 2
 * 输出：6
 * 解释：B = [2,8]
 * 示例 3：
 * <p>
 * 输入：A = [1,3,6], K = 3
 * 输出：3
 * 解释：B = [4,6,3]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * 0 <= K <= 10000
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-range-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SmallestRangeII {
    public static void main(String[] args) {
        int[] array = {1, 3, 6};
        int k = 3;
        System.out.println(solution(array, k));
    }

    private static int solution(int[] array, int k) {
        int max;
        int min;

        Arrays.sort(array);
        int result = array[array.length - 1] - array[0];
        for (int i = 1; i < array.length; i++) {
            min = Math.min(array[0] + k, array[i] - k);
            max = Math.max(array[i - 1] + k, array[array.length - 1] - k);

            result = Math.min(result, max - min);
        }

        return result;
    }
}
