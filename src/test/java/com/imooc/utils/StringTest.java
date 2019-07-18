package com.imooc.utils;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/6 0006 16:58
 */
public class StringTest {
    public static void main(String[] args) {
        String s = "hello,world";
        /** 1 转化为字符数组*/
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            System.out.println(aChar);

        }
        /** 2 进行揭穿*/
        String substring = s.substring(2);
        System.out.println(substring);
        String substring1 = s.substring(1, 6);
        System.out.println(substring + "区间的截取字符串，前闭后开");
        /** 3 字符串的拼接，
         * 综上，当对String对象进行拼接时，会创建一个新的字符串来存储新串。*/
        String s1 = s.concat("ppx is comming");
        /** 4 查找字符串的下边*/
        int hello = s.indexOf("hello");
        System.out.println(hello);
        System.out.println("怒哈");

    }
}
