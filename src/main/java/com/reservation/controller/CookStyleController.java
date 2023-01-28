package com.reservation.controller;

import com.github.pagehelper.PageInfo;
import com.reservation.common.JsonResult;
import com.reservation.dto.cook.style.CookStyleAddResDTO;
import com.reservation.dto.cook.style.CookStyleListResDTO;
import com.reservation.model.UsrCookStyle;
import com.reservation.service.CookStyleService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cook/style")
public class CookStyleController {

    private final CookStyleService cookStyleService;

    @PostMapping("list")
    public JsonResult<PageInfo<UsrCookStyle>> list(@RequestBody @Validated CookStyleListResDTO dto) {
        return JsonResult.ok(cookStyleService.list(dto));
    }

    @PostMapping("add")
    public JsonResult<String> add(@RequestBody @Validated CookStyleAddResDTO dto) {
        return JsonResult.ok(cookStyleService.add(dto));
    }

}
