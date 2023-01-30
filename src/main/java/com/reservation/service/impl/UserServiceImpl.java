package com.reservation.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.reservation.dto.sys.user.SysUserAddResDTO;
import com.reservation.dto.sys.user.SysUserChangeStatusResDTO;
import com.reservation.dto.sys.user.SysUserEditResDTO;
import com.reservation.dto.sys.user.SysUserListResDTO;
import com.reservation.dto.sys.user.SysUserListRespDTO;
import com.reservation.exception.AppException;
import com.reservation.mapper.UserMapper;
import com.reservation.model.SysConfig;
import com.reservation.model.SysUser;
import com.reservation.model.mapper.SysConfigMapper;
import com.reservation.model.mapper.SysUserMapper;
import com.reservation.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final SysUserMapper sysUserMapper;

    private final UserMapper userMapper;

    private final SysConfigMapper sysConfigMapper;


    @Override
    public PageInfo<SysUserListRespDTO> list(SysUserListResDTO dto) {
        PageHelper.startPage(Integer.parseInt(dto.getPageNo()), Integer.parseInt(dto.getPageSize()));
        return new PageInfo<>(userMapper.list(dto));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SysUserAddResDTO dto) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq(SysUser.COL_ACCOUNT, dto.getAccount());
        if (Objects.nonNull(sysUserMapper.selectOne(wrapper))) {
            throw new AppException("用户" + dto.getAccount() + "已存在");
        }
        SysUser sysUser = new SysUser();
        BeanUtil.copyProperties(dto, sysUser);
        if (StrUtil.isEmpty(sysUser.getPassword())) {
            SysConfig sysConfig = sysConfigMapper.selectById("0.sys.default.user.passwd");
            if (Objects.isNull(sysConfig)) {
                throw new AppException("字典项sys.default.user.passwd为空");
            }
            sysUser.setPassword(sysConfig.getValue());
        }
        sysUser.setPassword(DigestUtil.bcrypt(sysUser.getPassword()));
        sysUser.setStatus("00");
        sysUser.setId(IdUtil.getSnowflakeNextIdStr());
        sysUserMapper.insert(sysUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void edit(SysUserEditResDTO dto) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq(SysUser.COL_ACCOUNT, dto.getAccount());
        SysUser sysUser = sysUserMapper.selectOne(wrapper);
        if (Objects.isNull(sysUser)) {
            throw new AppException("用户" + dto.getAccount() + "不存在");
        }
        BeanUtil.copyProperties(dto, sysUser);
        if (StrUtil.isNotEmpty(dto.getPassword())) {
            sysUser.setPassword(DigestUtil.bcrypt(sysUser.getPassword()));
        }
        sysUserMapper.updateById(sysUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void changeStatus(SysUserChangeStatusResDTO dto) {
        SysUser sysUser = sysUserMapper.selectById(dto.getAccount());
        if (Objects.isNull(sysUser)) {
            throw new AppException("用户不存在");
        }
        sysUser.setStatus(dto.getStatus());
        sysUserMapper.updateById(sysUser);
    }
}
