package com.reservation.dto.access;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AccessLoginResDTO {

    @NotBlank(message = "用户名不能为空")
    private String account;

    @NotBlank(message = "密码不能为空")
    private String password;
}
