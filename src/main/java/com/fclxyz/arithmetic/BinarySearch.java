package com.fclxyz.arithmetic;

public class BinarySearch {

    public static void main(String[] args) {
        int[] hours = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(solution(hours, 3));
    }

    private static int solution(int[] hours, int key) {
        int min = 0;
        int max = hours.length - 1;
        while (min < max) {
            int mid = (max - min + 1) / 2;

            if (hours[mid] == key) {
                return mid;
            } else if (hours[mid] > key) {
                max = mid;
            } else {
                min = mid;
            }
        }

        return -1;
    }

}
