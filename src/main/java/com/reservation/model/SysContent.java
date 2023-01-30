package com.reservation.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 内容ID表
 */
@Data
@TableName(value = "sys_content")
public class SysContent implements Serializable {
    /**
     * 内容ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    /**
     * 内容key
     */
    @TableField(value = "cid")
    private String cid;

    /**
     * 内容名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 内容类型
     */
    @TableField(value = "type")
    private String type;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_CID = "cid";

    public static final String COL_NAME = "name";

    public static final String COL_TYPE = "type";
}