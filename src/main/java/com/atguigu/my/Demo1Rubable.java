package com.atguigu.my;

import java.util.function.DoubleBinaryOperator;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/21 0021 20:59
 */
public class Demo1Rubable {
    public static void main(String[] args) {
        Runnable runnable= () ->System.out.println("hello");
        new Thread(runnable).start();
        DoubleBinaryOperator uncaughtExceptionHandler = (x, y) -> Math.pow(x, y);
        System.out.println(uncaughtExceptionHandler);

    }
}
