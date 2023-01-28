package com.reservation.controller;

import com.reservation.common.JsonResult;
import com.reservation.dto.access.AccessLoginResDTO;
import com.reservation.dto.access.AccessLoginRespDTO;
import com.reservation.service.AccessService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("access")
public class AccessController {

    private final AccessService accessService;

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
