package com.imooc.exceptions;

import lombok.Data;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/15 0015 11:11
 */
@Data
public class ExceptionTest extends RuntimeException {
    private Integer code;

    public ExceptionTest(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public ExceptionTest() {
    }

    public static final void say() throws ExceptionTest {
        if (true) {
            throw new ExceptionTest("error is occur", 101);
        }

    }

    public static void main(String[] args) {
        say();

    }
}
