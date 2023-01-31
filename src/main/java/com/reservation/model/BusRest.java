package com.reservation.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 餐馆表
 */
@Data
@TableName(value = "bus_rest")
public class BusRest implements Serializable {
    /**
     * 餐馆ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    /**
     * 餐馆类别
     */
    @TableField(value = "category_id")
    private String categoryId;

    /**
     * 餐馆名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 餐馆图片
     */
    @TableField(value = "picture")
    private String picture;

    /**
     * 餐厅评
     */
    @TableField(value = "star")
    private String star;

    /**
     * 位置
     */
    @TableField(value = "location")
    private String location;

    /**
     * 经度
     */
    @TableField(value = "location_longitude")
    private String locationLongitude;

    /**
     * 纬度
     */
    @TableField(value = "location_latitude")
    private String locationLatitude;

    /**
     * 开业时间
     */
    @TableField(value = "open_date")
    private Date openDate;

    /**
     * 状态
     */
    @TableField(value = "status")
    private String status;

    /**
     * 简介
     */
    @TableField(value = "mark")
    private String mark;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_CATEGORY_ID = "category_id";

    public static final String COL_NAME = "name";

    public static final String COL_PICTURE = "picture";

    public static final String COL_STAR = "star";

    public static final String COL_LOCATION = "location";

    public static final String COL_LOCATION_LONGITUDE = "location_longitude";

    public static final String COL_LOCATION_LATITUDE = "location_latitude";

    public static final String COL_OPEN_DATE = "open_date";

    public static final String COL_STATUS = "status";

    public static final String COL_MARK = "mark";
}