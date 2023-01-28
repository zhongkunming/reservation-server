package com.reservation.mapper;

import com.reservation.model.SysDict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysDictMapper {

    SysDict selectById(@Param("key") String key);
}