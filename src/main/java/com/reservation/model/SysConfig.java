package com.reservation.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 配置表
 */
@Data
@TableName(value = "sys_config")
public class SysConfig implements Serializable {
    /**
     * 唯一ID
     */
    @TableId(value = "uid", type = IdType.INPUT)
    private String uid;

    /**
     * 配置项父ID
     */
    @TableField(value = "pid")
    private String pid;

    /**
     * 配置项ID
     */
    @TableField(value = "id")
    private String id;

    /**
     * 配置项内容
     */
    @TableField(value = "value")
    private String value;

    /**
     * 备注
     */
    @TableField(value = "mark")
    private String mark;

    private static final long serialVersionUID = 1L;

    public static final String COL_UID = "uid";

    public static final String COL_PID = "pid";

    public static final String COL_ID = "id";

    public static final String COL_VALUE = "value";

    public static final String COL_MARK = "mark";
}