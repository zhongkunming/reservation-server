package com.reservation.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 餐馆内食物分类表
 */
@Data
@TableName(value = "bus_food_category")
public class BusFoodCategory implements Serializable {
    /**
     * 分类ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    /**
     * 餐馆ID
     */
    @TableField(value = "restid")
    private String restid;

    /**
     * 名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 排序
     */
    @TableField(value = "order_number")
    private String orderNumber;

    /**
     * 简介
     */
    @TableField(value = "mark")
    private String mark;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_RESTID = "restid";

    public static final String COL_NAME = "name";

    public static final String COL_ORDER_NUMBER = "order_number";

    public static final String COL_MARK = "mark";
}