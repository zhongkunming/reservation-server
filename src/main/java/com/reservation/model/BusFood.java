package com.reservation.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 食物表
 */
@Data
@TableName(value = "bus_food")
public class BusFood implements Serializable {
    /**
     * 食物ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    /**
     * 餐馆ID
     */
    @TableField(value = "restid")
    private String restid;

    /**
     * 茶馆内食物分类ID
     */
    @TableField(value = "fcid")
    private String fcid;

    /**
     * 名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 价格
     */
    @TableField(value = "price")
    private Long price;

    /**
     * 图片
     */
    @TableField(value = "picture")
    private String picture;

    /**
     * 状态
     */
    @TableField(value = "status")
    private String status;

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

    public static final String COL_FCID = "fcid";

    public static final String COL_NAME = "name";

    public static final String COL_PRICE = "price";

    public static final String COL_PICTURE = "picture";

    public static final String COL_STATUS = "status";

    public static final String COL_ORDER_NUMBER = "order_number";

    public static final String COL_MARK = "mark";
}