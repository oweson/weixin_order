package com.imooc.utils;

import com.imooc.enums.CodeEnum;

/**枚举的工具类，返回就是泛型*/
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        /**枚举类的class*/
        for (T each: enumClass.getEnumConstants()) {
            /**t有code继承的接口*/
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
