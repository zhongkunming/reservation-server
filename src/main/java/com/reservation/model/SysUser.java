package com.reservation.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 */
@Data
@TableName(value = "sys_user")
public class SysUser implements Serializable {
    /**
     * 用户ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    /**
     * 用户名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 账户
     */
    @TableField(value = "account")
    private String account;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 头像
     */
    @TableField(value = "profile_picture")
    private String profilePicture;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 注册时间
     */
    @TableField(value = "regdate")
    private Date regdate;

    /**
     * 性别
     */
    @TableField(value = "gender")
    private String gender;

    /**
     * 状态
     */
    @TableField(value = "status")
    private String status;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_ACCOUNT = "account";

    public static final String COL_PASSWORD = "password";

    public static final String COL_PROFILE_PICTURE = "profile_picture";

    public static final String COL_EMAIL = "email";

    public static final String COL_REGDATE = "regdate";

    public static final String COL_GENDER = "gender";

    public static final String COL_STATUS = "status";
}