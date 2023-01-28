package com.reservation.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 餐厅信息
 */
@Data
@TableName(value = "bus_rest_info")
public class BusRestInfo implements Serializable {
    /**
     * 餐厅ID
     */
    @TableId(value = "rid", type = IdType.INPUT)
    private String rid;

    /**
     * 餐厅名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 餐厅简介
     */
    @TableField(value = "intro")
    private String intro;

    /**
     * 开业时间
     */
    @TableField(value = "open_date")
    private Date openDate;

    /**
     * 餐厅地址
     */
    @TableField(value = "locx")
    private String locx;

    /**
     * 餐厅地址
     */
    @TableField(value = "locy")
    private String locy;

    /**
     * 地址
     */
    @TableField(value = "loc")
    private String loc;

    private static final long serialVersionUID = 1L;

    public static final String COL_RID = "rid";

    public static final String COL_NAME = "name";

    public static final String COL_INTRO = "intro";

    public static final String COL_OPEN_DATE = "open_date";

    public static final String COL_LOCX = "locx";

    public static final String COL_LOCY = "locy";

    public static final String COL_LOC = "loc";
}