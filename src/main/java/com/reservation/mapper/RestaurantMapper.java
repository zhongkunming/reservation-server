package com.reservation.mapper;

import com.reservation.dto.bus.rest.BusRestListResDTO;
import com.reservation.dto.bus.rest.BusRestListRespDTO;
import com.reservation.dto.bus.rest.BusRestShowFoodResDTO;
import com.reservation.dto.bus.rest.BusRestShowFoodRespDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RestaurantMapper {
    List<BusRestListRespDTO> list(@Param("dto") BusRestListResDTO dto);

    List<BusRestShowFoodRespDTO> queryFootList(@Param("dto") BusRestShowFoodResDTO dto);
}
