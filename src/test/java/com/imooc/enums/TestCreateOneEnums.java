package com.imooc.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/6 0006 17:10
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TestCreateOneEnums {
    BEAUTI(100, "美美哒"), AUGLY(990, "丑逼");
    private Integer code;
    private String message;

    public static TestCreateOneEnums get(Integer code) {
        /**根据code返回值*/
        for (TestCreateOneEnums testCreateOneEnums : TestCreateOneEnums.values()) {
            if (testCreateOneEnums.getCode().equals(code)) {
                return testCreateOneEnums;
            }

        }
        return null;
    }


}
