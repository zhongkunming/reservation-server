package com.reservation.service;

import com.github.pagehelper.PageInfo;
import com.reservation.dto.sys.user.SysUserAddResDTO;
import com.reservation.dto.sys.user.SysUserListResDTO;
import com.reservation.dto.sys.user.SysUserListRespDTO;

public interface UserService {
    PageInfo<SysUserListRespDTO> list(SysUserListResDTO dto);

    String add(SysUserAddResDTO dto);
}
