package com.reservation.mapper;

import com.reservation.dto.sys.user.SysUserListResDTO;
import com.reservation.dto.sys.user.SysUserListRespDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {


    List<SysUserListRespDTO> list(@Param("dto") SysUserListResDTO dto);
}
