package com.reservation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.reservation.dto.cook.style.CookStyleListResDTO;
import com.reservation.mapper.UsrCookStyleMapper;
import com.reservation.model.UsrCookStyle;
import com.reservation.service.CookStyleService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CookStyleServiceImpl implements CookStyleService {

    @Resource
    private UsrCookStyleMapper usrCookStyleMapper;

    @Override
    public IPage<UsrCookStyle> list(CookStyleListResDTO dto) {
        QueryWrapper<UsrCookStyle> wrapper = new QueryWrapper<>();

        IPage<UsrCookStyle> page = PageDTO.of(Long.parseLong(dto.getPageNo()), Long.parseLong(dto.getPageSize()));
        page = usrCookStyleMapper.selectPage(page, wrapper);

        return page;
    }
}
