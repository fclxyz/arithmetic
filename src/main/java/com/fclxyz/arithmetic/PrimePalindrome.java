package com.fclxyz.arithmetic;

/**
 * 求出大于或等于 N 的最小回文素数。
 * <p>
 * 回顾一下，如果一个数大于 1，且其因数只有 1 和它自身，那么这个数是素数。
 * <p>
 * 例如，2，3，5，7，11 以及 13 是素数。
 * <p>
 * 回顾一下，如果一个数从左往右读与从右往左读是一样的，那么这个数是回文数。
 * <p>
 * 例如，12321 是回文数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：6
 * 输出：7
 * 示例 2：
 * <p>
 * 输入：8
 * 输出：11
 * 示例 3：
 * <p>
 * 输入：13
 * 输出：101
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/prime-palndrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PrimePalindrome {
    public static void main(String[] args) {
        System.out.println(solution(-99));
    }

    private static int solution(int N) {
        if (N < 2) {
            return 2;
        }

        int[] check = new int[]{2, 2, 2, 3, 5, 5, 7, 7, 11, 11, 11, 11};
        if (N < check.length && check[N] > 0) {
            return check[N];
        }

        for (; ; ) {
            int mod = N % 6;
            String cs = String.valueOf(N);
            // 新增了一个判断，用于跳过数字长度为偶数的区间
            if ((cs.length() & 1) == 0) {
                N = (int) Math.pow(10, cs.length()) + 1;
                continue;
            }

            // 原代码
            if ((mod == 1 || mod == 5)) {
                boolean isPrime = true, isPalindrome = true;
                for (int i = 5, j = 0,
                     L1 = (int) Math.sqrt(N),
                     strLen = cs.length(),
                     L2 = strLen >> 1;
                     i <= L1 || j < L2;
                     i += 6, ++j) {
                    if (i <= L1 && (N % i == 0 || N % (i + 2) == 0)) {
                        isPrime = false;
                        break;
                    }
                    if (j < L2 && cs.charAt(j) != cs.charAt(strLen - j - 1)) {
                        isPalindrome = false;
                        break;
                    }
                }
                if (isPrime && isPalindrome) {
                    return N;
                }
                N = mod == 1 ? N + 4 : N + 2;
            } else {
                N = mod == 0 ? N + 1 : N + (5 - mod);
            }
        }
    }
}



