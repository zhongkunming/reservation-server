package com.reservation.dto.bus.rest;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class BusRestEditResDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -786994286121840154L;

    @NotBlank(message = "餐厅ID不能为空")
    private String rid;

    @NotBlank(message = "餐厅名称不能为空")
    private String name;


    private String intro;


    @NotBlank(message = "开业时间不能为空")
    private Date openDate;


    private String locx;


    private String locy;

    private String loc;
}
