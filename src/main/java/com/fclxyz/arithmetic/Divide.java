package com.fclxyz.arithmetic;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author tomclfan
 * @since 2019-08-01 11:00
 */
public class Divide {
    public static void main(String[] args) {
        int result = solution(9999999, 2);
        System.out.println(result);
    }

    private static int solution(int dividend, int divisor) {
        int result = 0;
        boolean sign = dividend > 0 ^ divisor > 0;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int count = 0;
        while (dividend > divisor) {
            divisor <<= 1;
            count ++;
        }

        while (count > 0) {
            if (dividend > divisor) {
                dividend -= divisor;
                result += 1 << count;
            }

            count --;
            divisor >>= 1;
        }

        return sign ? -result : result;
    }
}