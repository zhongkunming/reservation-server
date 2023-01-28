package com.reservation.dto.sys.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


@Data
public class SysUserChangeStatusResDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -608428995691154547L;

    @NotBlank(message = "用户ID不能为空")
    private String userId;

    @NotBlank(message = "用户状态不能为空")
    private String status;

}
