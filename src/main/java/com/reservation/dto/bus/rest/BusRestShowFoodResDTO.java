package com.reservation.dto.bus.rest;

import com.reservation.dto.BasePageResDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

@Data
@EqualsAndHashCode(callSuper = false)
public class BusRestShowFoodResDTO extends BasePageResDTO {

    @Serial
    private static final long serialVersionUID = -786994286121840154L;

    /**
     * 餐馆ID
     */
    private String rid;


    /**
     * 茶馆内食物分类ID
     */
    private String fcid;
}
