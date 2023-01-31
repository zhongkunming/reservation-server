package com.reservation.dto.bus.rest;

import com.reservation.dto.BasePageResDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

@Data
@EqualsAndHashCode(callSuper = false)
public class BusRestShowFoodRespDTO extends BasePageResDTO {

    @Serial
    private static final long serialVersionUID = -786994286121840154L;

    /**
     * 食物ID
     */
    private String id;

    /**
     * 餐馆ID
     */
    private String restid;

    /**
     * 茶馆内食物分类ID
     */
    private String fcid;

    /**
     * 名称
     */
    private String name;

    /**
     * 价格
     */
    private Long price;

    /**
     * 图片
     */
    private String picture;

    /**
     * 状态
     */
    private String status;

    /**
     * 排序
     */
    private String orderNumber;

    /**
     * 简介
     */
    private String mark;
}
