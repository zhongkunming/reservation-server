package com.reservation.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class BasePageResDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -5514092308842006697L;

    @NotBlank(message = "页码不能为空")
    private String pageNo;

    @NotBlank(message = "每页数量不能为空")
    private String pageSize;
}
