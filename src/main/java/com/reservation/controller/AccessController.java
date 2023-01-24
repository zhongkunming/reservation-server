package com.reservation.controller;

import com.reservation.common.JsonResult;
import com.reservation.dto.access.AccessLoginResDTO;
import com.reservation.dto.access.AccessLoginRespDTO;
import com.reservation.service.AccessService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("access")
public class AccessController {

    @Resource
    private AccessService accessService;

    @PostMapping("login")
    public JsonResult<AccessLoginRespDTO> login(@RequestBody @Validated AccessLoginResDTO dto) {
        return JsonResult.ok(accessService.login(dto));
    }

    @PostMapping("logout")
    public JsonResult<String> logout() {
        accessService.logout();
        return JsonResult.ok();
    }
}
