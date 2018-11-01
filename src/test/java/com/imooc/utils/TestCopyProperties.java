package com.imooc.utils;

import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/7 0007 9:58
 */
@Data
public class TestCopyProperties {
    public static void main(String[] args) {
        a aa = new a();
        b bb = new b();
        bb.setX(100);
        bb.setY(10000);
        BeanUtils.copyProperties(bb, aa);
        System.out.println(aa.toString());
        System.out.println(aa.getX()+aa.getY());

    }
}

class a {
    public int x;
    public int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

class b {
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int x;
    public int y;
}
