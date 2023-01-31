package com.reservation.dto.bus.rest;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class BusRestShowStatusResDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -786994286121840154L;

    @NotBlank(message = "餐厅ID不能为空")
    private String id;

    /**
     * 状态
     */
    @NotBlank(message = "餐厅状态不能为空")
    private String status;
}
