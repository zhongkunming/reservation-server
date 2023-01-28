package com.reservation.mapper;


import com.reservation.dto.bus.rest.BusRestListResDTO;
import com.reservation.dto.bus.rest.BusRestListRespDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RestaurantMapper {
    List<BusRestListRespDTO> list(@Param("dto") BusRestListResDTO dto);
}
