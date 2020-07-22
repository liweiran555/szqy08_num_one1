package com.szqy08.controller;

import com.szqy08.entity.Result;
import com.szqy08.util.MyConstants;

/**
 * fileName:BaseController
 * description:
 * @author:cxj
 * createTime:2020/7/18 0018 下午 4:15
 * version:1.0.0
 */
public class BaseController {
    /**
     * 成功带数据
     * @param object
     * @return
     */
    public Result success(Object object){
        Result result = new Result();
        result.setCode(MyConstants.OPERATION_SUCCESS_CODE);
        result.setMsg(MyConstants.OPERATION_SUCCESS_MESSAGE);
        result.setData(object);
        return result;
    }

    /**
     * 成功但不带数据
     * @return
     */
    public Result success(){
        return success(null);
    }

    /**
     * 返回错误信息
     * @param code
     * @param msg
     * @return
     */
    public Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    /**
     * 失败但默认信息
     * @return
     */
    public Result error(){
        Result result = new Result();
        result.setCode(MyConstants.OPERATION_FAIL_CODE);
        result.setMsg(MyConstants.OPERATION_FAIL_MESSAGE);
        return result;
    }
}
