package com.reservation.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class AppException extends RuntimeException {

    private String msg;

    public AppException(String msg) {
        super(msg);
        this.msg = msg;
    }
}

