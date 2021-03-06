package com.fclxyz.arithmetic.jzoffer;

import java.util.Arrays;

/**
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 跳上 n-1 级台阶，可以从 n-2 级跳 1 级上去，也可以从 n-3 级跳 2 级上去...，那么
 * <p>
 * f(n-1) = f(n-2) + f(n-3) + ... + f(0)
 * 同样，跳上 n 级台阶，可以从 n-1 级跳 1 级上去，也可以从 n-2 级跳 2 级上去... ，那么
 * <p>
 * f(n) = f(n-1) + f(n-2) + ... + f(0)
 * 综上可得
 * <p>
 * f(n) - f(n-1) = f(n-1)
 * 即
 * <p>
 * f(n) = 2*f(n-1)
 */
public class Test011 {
    public static int rectCover(int target) {
        int[] dp = new int[target + 1];

        dp[0] = 0;
        for (int i = 0; i <= target; i++) {
            if (i <= 2) {
                dp[i] = i;
                continue;
            }

            dp[i] = 2 * dp[i - 1];
        }

        return dp[target];

//        if (target <= 2) {
//            return target;
//        } else {
//            return 2 * rectCover(target - 1);
//        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(rectCover(1));
        System.out.println(rectCover(2));
        System.out.println(rectCover(3));
        System.out.println(rectCover(4));
        System.out.println(rectCover(10));
    }
}
