package com.reservation.service;

import com.github.pagehelper.PageInfo;
import com.reservation.dto.bus.rest.BusRestAddResDTO;
import com.reservation.dto.bus.rest.BusRestEditResDTO;
import com.reservation.dto.bus.rest.BusRestListResDTO;
import com.reservation.dto.bus.rest.BusRestListRespDTO;

public interface RestaurantService {
    PageInfo<BusRestListRespDTO> list(BusRestListResDTO dto);

    void add(BusRestAddResDTO dto);

    void edit(BusRestEditResDTO dto);
}
