package com.reservation.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 菜系表
 */
@Data
@TableName(value = "usr_cook_style")
public class UsrCookStyle implements Serializable {
    /**
     * 菜系ID
     */
    @TableId(value = "style_id", type = IdType.INPUT)
    private String styleId;

    /**
     * 菜系名称
     */
    @TableField(value = "style_name")
    private String styleName;

    /**
     * 菜系介绍
     */
    @TableField(value = "style_intro")
    private String styleIntro;

    @Serial
    private static final long serialVersionUID = 1L;

    public static final String COL_STYLE_ID = "style_id";

    public static final String COL_STYLE_NAME = "style_name";

    public static final String COL_STYLE_INTRO = "style_intro";
}