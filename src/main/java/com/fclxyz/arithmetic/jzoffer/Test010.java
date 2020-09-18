package com.fclxyz.arithmetic.jzoffer;

/**
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */
public class Test010 {
    public static int rectCover(int target) {
        if (target <= 2) {
            return target;
        } else {
            return rectCover(target - 1) + rectCover(target - 2);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(rectCover(1));
        System.out.println(rectCover(2));
        System.out.println(rectCover(3));
        System.out.println(rectCover(4));
        System.out.println(rectCover(5));
    }
}
