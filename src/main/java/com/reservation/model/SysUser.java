package com.reservation.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
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
    @TableId(value = "user_id", type = IdType.INPUT)
    private String userId;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 登录密码
     */
    @TableField(value = "passwd")
    private String passwd;

    /**
     * 昵称
     */
    @TableField(value = "nick_name")
    private String nickName;

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
     * 插入时间
     */
    @TableField(value = "created_time")
    private Date createdTime;

    /**
     * 插入人
     */
    @TableField(value = "created_user")
    private String createdUser;

    /**
     * 更新时间
     */
    @TableField(value = "updated_time")
    private Date updatedTime;

    /**
     * 更新人
     */
    @TableField(value = "updated_user")
    private String updatedUser;

    @Serial
    private static final long serialVersionUID = 1L;

    public static final String COL_USER_ID = "user_id";

    public static final String COL_USERNAME = "username";

    public static final String COL_PASSWD = "passwd";

    public static final String COL_NICK_NAME = "nick_name";

    public static final String COL_PROFILE_PICTURE = "profile_picture";

    public static final String COL_EMAIL = "email";

    public static final String COL_CREATED_TIME = "created_time";

    public static final String COL_CREATED_USER = "created_user";

    public static final String COL_UPDATED_TIME = "updated_time";

    public static final String COL_UPDATED_USER = "updated_user";
}