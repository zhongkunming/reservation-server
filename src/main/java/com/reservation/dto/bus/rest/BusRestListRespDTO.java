package com.reservation.dto.bus.rest;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class BusRestListRespDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -786994286121840154L;

    private String rid;

    private String name;

    private String intro;

    private Date openDate;

    private String locx;

    private String locy;

    private String loc;
}
