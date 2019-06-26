package com.imooc.exception;

import com.imooc.enums.ResultEnum;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/7 0007 9:37
 */
public class SellException extends RuntimeException {
    private Integer code;

    /**
     * 1 枚举信息提示，提示信息封装死的
     */
    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    /**
     * 2 提示信息手动的添加
     */
    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
