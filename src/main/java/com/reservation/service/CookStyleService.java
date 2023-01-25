package com.reservation.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.reservation.dto.cook.style.CookStyleListResDTO;
import com.reservation.model.UsrCookStyle;

public interface CookStyleService {
    IPage<UsrCookStyle> list(CookStyleListResDTO dto);
}
