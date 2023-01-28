package com.reservation.controller;


import com.github.pagehelper.PageInfo;
import com.reservation.common.JsonResult;
import com.reservation.dto.sys.user.SysUserAddResDTO;
import com.reservation.dto.sys.user.SysUserChangeStatusResDTO;
import com.reservation.dto.sys.user.SysUserEditResDTO;
import com.reservation.dto.sys.user.SysUserListResDTO;
import com.reservation.dto.sys.user.SysUserListRespDTO;
import com.reservation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/sys/user")
public class UserController {

    private final UserService userService;


    @PostMapping("list")
    public JsonResult<PageInfo<SysUserListRespDTO>> list(@RequestBody @Validated SysUserListResDTO dto) {
        return JsonResult.ok(userService.list(dto));
    }

    @PostMapping("add")
    public JsonResult<String> add(@RequestBody @Validated SysUserAddResDTO dto) {
        userService.add(dto);
        return JsonResult.ok();
    }

    @PostMapping("edit")
    public JsonResult<String> edit(@RequestBody @Validated SysUserEditResDTO dto) {
        userService.edit(dto);
        return JsonResult.ok();
    }

    @PostMapping("/change/status")
    public JsonResult<String> changeStatus(@RequestBody @Validated SysUserChangeStatusResDTO dto) {
        userService.changeStatus(dto);
        return JsonResult.ok();
    }
}
