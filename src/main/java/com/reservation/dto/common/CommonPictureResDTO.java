package com.reservation.dto.common;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CommonPictureResDTO {

    @NotBlank(message = "通用图片key为空")
    private String key;
}
