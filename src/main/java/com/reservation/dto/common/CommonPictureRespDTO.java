package com.reservation.dto.common;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class CommonPictureRespDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -1100622660155455831L;

    private String url;
}
