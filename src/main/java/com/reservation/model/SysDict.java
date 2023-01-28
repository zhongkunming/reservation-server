package com.reservation.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 字典表
 */
@Data
@TableName(value = "sys_dict")
public class SysDict implements Serializable {
    /**
     * 字典Key
     */
    @TableField(value = "dkey")
    private String dkey;

    /**
     * 父key
     */
    @TableField(value = "pkey")
    private String pkey;

    /**
     * 字典Value
     */
    @TableField(value = "dvalue")
    private String dvalue;

    /**
     * 备注
     */
    @TableField(value = "dintro")
    private String dintro;

    private static final long serialVersionUID = 1L;

    public static final String COL_DKEY = "dkey";

    public static final String COL_PKEY = "pkey";

    public static final String COL_DVALUE = "dvalue";

    public static final String COL_DINTRO = "dintro";
}