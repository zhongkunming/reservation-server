package com.reservation.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
    * 内容平台ID表
    */
@Data
@TableName(value = "sys_content_map")
public class SysContentMap implements Serializable {
    /**
     * 内容ID
     */
    @TableId(value = "cid", type = IdType.INPUT)
    private String cid;

    /**
     * 内容名称
     */
    @TableField(value = "cname")
    private String cname;

    @TableField(value = "ctype")
    private String ctype;

    @Serial
    private static final long serialVersionUID = 1L;

    public static final String COL_CID = "cid";

    public static final String COL_CNAME = "cname";

    public static final String COL_CTYPE = "ctype";
}