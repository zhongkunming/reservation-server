package com.reservation.controller;


import com.github.pagehelper.PageInfo;
import com.reservation.common.JsonResult;
import com.reservation.dto.bus.rest.BusRestAddResDTO;
import com.reservation.dto.bus.rest.BusRestEditResDTO;
import com.reservation.dto.bus.rest.BusRestListResDTO;
import com.reservation.dto.bus.rest.BusRestListRespDTO;
import com.reservation.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bus/rest")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("list")
    public JsonResult<PageInfo<BusRestListRespDTO>> list(@RequestBody @Validated BusRestListResDTO dto) {
        return JsonResult.ok(restaurantService.list(dto));
    }

    @PostMapping("add")
    public JsonResult<String> add(@RequestBody @Validated BusRestAddResDTO dto) {
        restaurantService.add(dto);
        return JsonResult.ok();
    }

    @PostMapping("edit")
    public JsonResult<String> edit(@RequestBody @Validated BusRestEditResDTO dto) {
        restaurantService.edit(dto);
        return JsonResult.ok();
    }
}
