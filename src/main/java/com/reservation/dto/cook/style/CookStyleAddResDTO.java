package com.reservation.dto.cook.style;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class CookStyleAddResDTO implements Serializable {


    @Serial
    private static final long serialVersionUID = -8872441615170192570L;


    @NotBlank(message = "菜系名称不能为空")
    private String styleName;

    /**
     * 菜系介绍
     */
    private String styleIntro;

}
