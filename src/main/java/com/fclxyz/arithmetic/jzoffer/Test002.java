package com.fclxyz.arithmetic.jzoffer;

/**
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 * <p>
 * Consider the following matrix:
 * {
 * {1,   4,  7, 11, 15},
 * {2,   5,  8, 12, 19},
 * {3,   6,  9, 16, 22},
 * {10, 13, 14, 17, 24},
 * {18, 21, 23, 26, 30}
 * }
 * <p>
 * Given target = 5, return true.
 * Given target = 20, return false.
 */
public class Test002 {
    public static boolean find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }

        int row = 0;
        int column = array[0].length - 1;
        while (row <= array.length - 1 && column >= 0) {
            int currentNum = array[row][column];
            if (target > currentNum) {
                row++;
            } else if (target < currentNum) {
                column--;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int array[][] = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println(find(5, array));
        System.out.println(find(20, array));
    }
}
