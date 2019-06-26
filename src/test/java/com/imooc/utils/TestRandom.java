package com.imooc.utils;

import java.util.Random;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/6 0006 16:54
 */
public class TestRandom {
    /**
     * 加上同步，多线程下的安全
     */
    public static synchronized void demo1() {
        Random random = new Random();
        for (int i1 = 0; i1 < 10; i1++) {
            /**用于订单号的生成*/
            int i = random.nextInt(90000) + 10000;
            System.out.println(System.currentTimeMillis() + i);

        }

    }

    public static void main(String[] args) {
        demo1();

    }
}
