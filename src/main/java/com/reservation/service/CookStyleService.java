package com.reservation.service;

import com.github.pagehelper.PageInfo;
import com.reservation.dto.cook.style.CookStyleAddResDTO;
import com.reservation.dto.cook.style.CookStyleListResDTO;
import com.reservation.model.UsrCookStyle;

public interface CookStyleService {
    PageInfo<UsrCookStyle> list(CookStyleListResDTO dto);

    String add(CookStyleAddResDTO dto);
}
