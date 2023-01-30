package com.reservation.dto.sys.user;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class SysUserListRespDTO implements Serializable {


    @Serial
    private static final long serialVersionUID = 3471519276774966860L;

    private String id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 账户
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像
     */
    private String profilePicture;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 注册时间
     */
    private Date regdate;

    /**
     * 性别
     */
    private String gender;

    /**
     * 状态
     */
    private String status;

}
