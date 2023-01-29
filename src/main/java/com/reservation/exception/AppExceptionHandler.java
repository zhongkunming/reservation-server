package com.reservation.exception;

import cn.hutool.core.util.StrUtil;
import com.reservation.common.JsonResult;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class AppExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public JsonResult<String> exception(Exception e) {
        String msg;
        if (e instanceof MethodArgumentNotValidException ex) {
            msg = ex.getBindingResult().getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(","));
        } else if (e instanceof AppException ex) {
            msg = StrUtil.isBlank(ex.getMsg()) ? ex.getMessage() : ex.getMsg();
        } else {
            msg = "系统异常，请联系管理员";
        }

        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (Objects.nonNull(sra)) {
            HttpServletRequest request = sra.getRequest();
            String uri = request.getRequestURI();
            log.error("请求地址: [{}], 发生异常: [{}]", uri, msg);
        } else {
            log.error("请求地址: [], 发生异常: [{}]", msg);
        }
        log.error("", e);
        return JsonResult.error(msg);

    }
}
