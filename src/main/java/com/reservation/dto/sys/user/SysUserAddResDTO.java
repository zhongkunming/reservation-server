package com.reservation.dto.sys.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class SysUserAddResDTO implements Serializable {


    @Serial
    private static final long serialVersionUID = -5905184924648362210L;


    @NotBlank(message = "用户名不能为空")
    private String userName;

    @NotBlank(message = "昵称不能为空")
    private String nickName;

    private String email;

    private String passwd;

    private String profilePicture;

    private String status;
}
