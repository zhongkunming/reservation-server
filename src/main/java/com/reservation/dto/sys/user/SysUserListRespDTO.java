package com.reservation.dto.sys.user;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class SysUserListRespDTO implements Serializable {


    @Serial
    private static final long serialVersionUID = 3471519276774966860L;

    private String userId;

    private String username;

    private String nickName;

    private String profilePicture;

    private String email;

    private String status;
}
