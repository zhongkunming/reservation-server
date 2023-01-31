package com.reservation.service;

import com.github.pagehelper.PageInfo;
import com.reservation.dto.bus.rest.BusRestAddResDTO;
import com.reservation.dto.bus.rest.BusRestChangeStatusResDTO;
import com.reservation.dto.bus.rest.BusRestEditResDTO;
import com.reservation.dto.bus.rest.BusRestListResDTO;
import com.reservation.dto.bus.rest.BusRestListRespDTO;
import com.reservation.dto.bus.rest.BusRestShowFoodResDTO;
import com.reservation.dto.bus.rest.BusRestShowFoodRespDTO;

public interface RestaurantService {
    PageInfo<BusRestListRespDTO> list(BusRestListResDTO dto);

    void add(BusRestAddResDTO dto);

    void edit(BusRestEditResDTO dto);

    void changeStatus(BusRestChangeStatusResDTO dto);

    PageInfo<BusRestShowFoodRespDTO> showFood(BusRestShowFoodResDTO dto);
}
