package com.reservation.controller;

import com.reservation.common.JsonResult;
import com.reservation.dto.common.CommonPictureResDTO;
import com.reservation.dto.common.CommonPictureRespDTO;
import com.reservation.service.CommonService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/common")
public class CommonController {

    private final CommonService commonService;

    @ResponseBody
    @PostMapping("/picture/link")
    public JsonResult<CommonPictureRespDTO> pictureLink(@RequestBody @Validated CommonPictureResDTO dto) {
        return JsonResult.ok(commonService.pictureLink(dto));
    }

    @GetMapping("/picture/d")
    public void pictureDirect(@RequestParam("key") @Validated @NotBlank(message = "文件key为空") String key) {
        commonService.pictureDirect(key);
    }

}
