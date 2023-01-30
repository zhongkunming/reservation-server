package com.reservation.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单详情表
 */
@Data
@TableName(value = "bus_order_detail")
public class BusOrderDetail implements Serializable {
    /**
     * 订单详情ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    /**
     * 订单ID
     */
    @TableField(value = "oid")
    private String oid;

    /**
     * 餐馆ID
     */
    @TableField(value = "restid")
    private String restid;

    /**
     * 食物ID
     */
    @TableField(value = "fid")
    private String fid;

    /**
     * 下单时间
     */
    @TableField(value = "order_time")
    private Date orderTime;

    /**
     * 评价星级
     */
    @TableField(value = "eval_star")
    private String evalStar;

    /**
     * 评价时间
     */
    @TableField(value = "eval_time")
    private Date evalTime;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_OID = "oid";

    public static final String COL_RESTID = "restid";

    public static final String COL_FID = "fid";

    public static final String COL_ORDER_TIME = "order_time";

    public static final String COL_EVAL_STAR = "eval_star";

    public static final String COL_EVAL_TIME = "eval_time";
}