package com.reservation.service;

import com.github.pagehelper.PageInfo;
import com.reservation.dto.sys.user.SysUserAddResDTO;
import com.reservation.dto.sys.user.SysUserChangeStatusResDTO;
import com.reservation.dto.sys.user.SysUserEditResDTO;
import com.reservation.dto.sys.user.SysUserListResDTO;
import com.reservation.dto.sys.user.SysUserListRespDTO;

public interface UserService {
    PageInfo<SysUserListRespDTO> list(SysUserListResDTO dto);

    void add(SysUserAddResDTO dto);

    void edit(SysUserEditResDTO dto);

    void changeStatus(SysUserChangeStatusResDTO dto);
}
