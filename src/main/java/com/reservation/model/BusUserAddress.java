package com.reservation.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 收获地址
 */
@Data
@TableName(value = "bus_user_address")
public class BusUserAddress implements Serializable {
    /**
     * 地址ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    /**
     * 用户ID
     */
    @TableField(value = "uid")
    private String uid;

    /**
     * 收货地址
     */
    @TableField(value = "location")
    private String location;

    /**
     * 收货地址经度
     */
    @TableField(value = "location_longitude")
    private String locationLongitude;

    /**
     * 收货地址纬度
     */
    @TableField(value = "location_latitude")
    private String locationLatitude;

    /**
     * 状态
     */
    @TableField(value = "status")
    private String status;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_UID = "uid";

    public static final String COL_LOCATION = "location";

    public static final String COL_LOCATION_LONGITUDE = "location_longitude";

    public static final String COL_LOCATION_LATITUDE = "location_latitude";

    public static final String COL_STATUS = "status";
}