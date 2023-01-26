package com.reservation.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.reservation.dto.cook.style.CookStyleAddResDTO;
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

    @Override
    public String add(CookStyleAddResDTO dto) {
        UsrCookStyle usrCookStyle = new UsrCookStyle();
        dto.setStyleIntro(StrUtil.isEmpty(dto.getStyleIntro()) ? dto.getStyleName() : dto.getStyleIntro());
        BeanUtil.copyProperties(dto, usrCookStyle);
        usrCookStyle.setStyleId(IdUtil.getSnowflake().nextIdStr());
        usrCookStyleMapper.insert(usrCookStyle);
        return "OK";
    }
}
