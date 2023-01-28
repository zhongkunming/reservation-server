package com.reservation.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.reservation.dto.bus.rest.BusRestAddResDTO;
import com.reservation.dto.bus.rest.BusRestEditResDTO;
import com.reservation.dto.bus.rest.BusRestListResDTO;
import com.reservation.dto.bus.rest.BusRestListRespDTO;
import com.reservation.exception.AppException;
import com.reservation.mapper.BusRestInfoMapper;
import com.reservation.mapper.RestaurantMapper;
import com.reservation.model.BusRestInfo;
import com.reservation.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Slf4j
@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final BusRestInfoMapper busRestInfoMapper;

    private final RestaurantMapper restaurantMapper;

    @Override
    public PageInfo<BusRestListRespDTO> list(BusRestListResDTO dto) {
        PageHelper.startPage(Integer.parseInt(dto.getPageNo()), Integer.parseInt(dto.getPageSize()));
        return new PageInfo<>(restaurantMapper.list(dto));
    }

    @Override
    public void add(BusRestAddResDTO dto) {
        BusRestInfo busRestInfo = new BusRestInfo();
        BeanUtil.copyProperties(dto, busRestInfo);
        busRestInfo.setRid(IdUtil.getSnowflakeNextIdStr());
        busRestInfoMapper.insert(busRestInfo);
    }

    @Override
    public void edit(BusRestEditResDTO dto) {
        QueryWrapper<BusRestInfo> wrapper = new QueryWrapper<>();
        wrapper.eq(BusRestInfo.COL_RID, dto.getRid());
        BusRestInfo busRestInfo = busRestInfoMapper.selectOne(wrapper);
        if (Objects.isNull(busRestInfo)) {
            throw new AppException("餐厅" + dto.getName() + "不存在");
        }
        BeanUtil.copyProperties(dto, busRestInfo);
        busRestInfoMapper.updateById(busRestInfo);
    }
}
