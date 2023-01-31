package com.reservation.dto.bus.rest;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class BusRestAddResDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -786994286121840154L;

    private String id;

    /**
     * 餐馆类别
     */
    @NotBlank(message = "餐厅类别不能为空")
    private String categoryId;

    /**
     * 餐馆名称
     */
    @NotBlank(message = "餐厅名称不能为空")
    private String name;

    /**
     * 简介
     */
    private String mark;

    /**
     * 位置
     */
    @NotBlank(message = "餐厅位置不能为空")
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
    @NotBlank(message = "开业时间不能为空")
    private Date openDate;

    /**
     * 状态
     */
    @NotBlank(message = "餐厅状态不能为空")
    private String status;
}
