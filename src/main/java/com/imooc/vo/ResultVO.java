package com.imooc.vo;

import lombok.Data;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/1 0001 12:06
 * 结果信息返回类
 */
@Data
public class ResultVO<T> {
    /**
     * 1 错误码
     */
    private Integer code;
    /**
     * 2 提示信息
     */
    private String message;
    /**
     * 3 具体内容
     */
    private T data;
}
