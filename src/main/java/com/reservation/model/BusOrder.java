package com.reservation.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单表
 */
@Data
@TableName(value = "bus_order")
public class BusOrder implements Serializable {
    /**
     * 订单ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    /**
     * 用户ID
     */
    @TableField(value = "uid")
    private String uid;

    /**
     * 餐馆ID
     */
    @TableField(value = "restid")
    private String restid;

    /**
     * 创建时间
     */
    @TableField(value = "created_time")
    private Date createdTime;

    /**
     * 下单时间
     */
    @TableField(value = "order_time")
    private Date orderTime;

    /**
     * 送达时间
     */
    @TableField(value = "forward_time")
    private Date forwardTime;

    /**
     * 状态
     */
    @TableField(value = "status")
    private String status;

    /**
     * 评价内容
     */
    @TableField(value = "eval")
    private String eval;

    /**
     * 评价时间
     */
    @TableField(value = "eval_time")
    private Date evalTime;

    /**
     * 评价星级
     */
    @TableField(value = "eval_star")
    private String evalStar;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_UID = "uid";

    public static final String COL_RESTID = "restid";

    public static final String COL_CREATED_TIME = "created_time";

    public static final String COL_ORDER_TIME = "order_time";

    public static final String COL_FORWARD_TIME = "forward_time";

    public static final String COL_STATUS = "status";

    public static final String COL_EVAL = "eval";

    public static final String COL_EVAL_TIME = "eval_time";

    public static final String COL_EVAL_STAR = "eval_star";
}