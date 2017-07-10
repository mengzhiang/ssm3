package com.zhiang.util;

import java.util.HashMap;

/**
 *
 */
public class RestResult extends HashMap<String, Object> {

    private static final long serialVersionUID = 146712653058091673L;

    public static RestResult success(Object data) {

        return getRestResult(true,RestConstant.SUCCESS,data);
    }


    public static RestResult failure(String errMsg, Object data) {

        return getRestResult(false,errMsg,data);
    }


    public static RestResult failure(String errMsg) {
        return failure(errMsg, null);
    }

    private static RestResult getRestResult(boolean success,String msg,Object data){
        RestResult result = new RestResult();
        result.put(RestConstant.SUCCESS, success);
        result.put(RestConstant.MESSAGE, msg);
        result.put(RestConstant.DATA, data);
        return result;
    }

}

