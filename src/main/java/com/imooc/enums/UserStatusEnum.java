package com.imooc.enums;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/11/4 0004 19:54
 */
public enum UserStatusEnum {
    ILLEGAL(0,"被封号"),VALID(1,"合法用户");
    private Integer code;
    private String message;

    UserStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    UserStatusEnum() {
    }
}
