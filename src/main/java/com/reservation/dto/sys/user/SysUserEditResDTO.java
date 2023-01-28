package com.reservation.dto.sys.user;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class SysUserEditResDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 7438257828664287546L;

    @NotBlank(message = "用户名不能为空")
    private String userName;

    @NotBlank(message = "昵称不能为空")
    private String nickName;

    private String email;

    @NotBlank(message = "密码不能为空")
    private String passwd;

    private String profilePicture;

    @NotBlank(message = "用户状态不能为空")
    private String status;
}
