package com.imooc.enums;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/6 0006 17:14
 */
public class TestMainEnum {
    public static void main(String[] args) {
        Integer code = TestCreateOneEnums.BEAUTI.getCode();
        String message = TestCreateOneEnums.BEAUTI.getMessage();
        System.out.println(code + message);
        TestCreateOneEnums testCreateOneEnums = TestCreateOneEnums.get(100);
        System.out.println(testCreateOneEnums);
    }
}
