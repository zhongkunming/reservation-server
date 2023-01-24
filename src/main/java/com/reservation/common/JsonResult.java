package com.reservation.common;

import cn.hutool.core.util.StrUtil;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class JsonResult<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 6260349457375528009L;

    private boolean success = true;

    private String message = "请求成功";

    private T data;


    public static <T> JsonResult<T> ok() {
        return new JsonResult<>();
    }

    public static <T> JsonResult<T> okMessage(String message) {
        JsonResult<T> result = ok();
        result.setMessage(message);
        return result;
    }

    public static <T> JsonResult<T> ok(T data) {
        JsonResult<T> result = ok();
        result.setData(data);
        return result;
    }

    public static <T> JsonResult<T> error() {
        JsonResult<T> result = new JsonResult<>();
        result.setSuccess(false);
        result.setMessage("请求发生异常，请联系管理员");
        return result;
    }

    public static <T> JsonResult<T> error(String message) {
        JsonResult<T> result = new JsonResult<>();
        result.setSuccess(false);
        result.setMessage(StrUtil.isBlank(message) ? "请求发生异常，请联系管理员" : message);
        return result;
    }
}
