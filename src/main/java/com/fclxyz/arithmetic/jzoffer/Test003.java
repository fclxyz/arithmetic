package com.fclxyz.arithmetic.jzoffer;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Test003 {
    public static String replaceSpace(String str) {
        return str.replace(" ", "%20");
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("We Are Happy"));
    }
}
