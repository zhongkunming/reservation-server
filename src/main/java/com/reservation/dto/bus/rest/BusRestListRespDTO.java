package com.reservation.dto.bus.rest;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class BusRestListRespDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -786994286121840154L;

    private String id;

    /**
     * 餐馆类别
     */
    private String categoryId;

    /**
     * 餐馆名称
     */
    private String name;

    /**
     * 简介
     */
    private String mark;

    /**
     * 位置
     */
    private String location;

    /**
     * 经度
     */
    private String locationLongitude;

    /**
     * 纬度
     */
    private String locationLatitude;

    /**
     * 开业时间
     */
    private Date openDate;

    /**
     * 状态
     */
    private String status;
}
