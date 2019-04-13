package com.imooc.utils;


import com.imooc.vo.ResultVO;


public class ResultVOUtil {
    /**
     * 1 成功返回数据
     */
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMessage("成功");
        return resultVO;
    }

    /**
     * 2 成功什么也不返回；
     */
    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMessage(msg);
        return resultVO;
    }
}
