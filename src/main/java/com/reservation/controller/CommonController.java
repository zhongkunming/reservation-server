package com.reservation.controller;

import com.reservation.common.JsonResult;
import com.reservation.dto.common.CommonPictureResDTO;
import com.reservation.dto.common.CommonPictureRespDTO;
import com.reservation.service.CommonService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("common")
public class CommonController {

    @Resource
    private CommonService commonService;

    @ResponseBody
    @PostMapping("picture")
    public JsonResult<CommonPictureRespDTO> picture(@RequestBody @Validated CommonPictureResDTO dto) {
        return JsonResult.ok(commonService.picture(dto));
    }

}
