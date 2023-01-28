package com.reservation.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.reservation.dto.cook.style.CookStyleAddResDTO;
import com.reservation.dto.cook.style.CookStyleListResDTO;
import com.reservation.mapper.UsrCookStyleMapper;
import com.reservation.model.UsrCookStyle;
import com.reservation.service.CookStyleService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CookStyleServiceImpl implements CookStyleService {

    private final UsrCookStyleMapper usrCookStyleMapper;

    @Override
    public PageInfo<UsrCookStyle> list(CookStyleListResDTO dto) {
        PageHelper.startPage(Integer.parseInt(dto.getPageNo()), Integer.parseInt(dto.getPageSize()));
        QueryWrapper<UsrCookStyle> wrapper = new QueryWrapper<>();
        return new PageInfo<>(usrCookStyleMapper.selectList(wrapper));
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
