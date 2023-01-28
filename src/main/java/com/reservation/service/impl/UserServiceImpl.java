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
import com.reservation.mapper.SysDictMapper;
import com.reservation.mapper.SysUserMapper;
import com.reservation.mapper.UserMapper;
import com.reservation.model.SysDict;
import com.reservation.model.SysUser;
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

    private final SysDictMapper sysDictMapper;


    @Override
    public PageInfo<SysUserListRespDTO> list(SysUserListResDTO dto) {
        PageHelper.startPage(Integer.parseInt(dto.getPageNo()), Integer.parseInt(dto.getPageSize()));
        return new PageInfo<>(userMapper.list(dto));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SysUserAddResDTO dto) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq(SysUser.COL_USERNAME, dto.getUserName());
        if (Objects.nonNull(sysUserMapper.selectOne(wrapper))) {
            throw new AppException("用户" + dto.getUserName() + "已存在");
        }
        SysUser sysUser = new SysUser();
        BeanUtil.copyProperties(dto, sysUser);
        if (StrUtil.isEmpty(sysUser.getPasswd())) {
            SysDict sysDict = sysDictMapper.selectById("sys.default.user.passwd");
            if (Objects.isNull(sysDict)) {
                throw new AppException("字典项sys.default.user.passwd为空");
            }
            sysUser.setPasswd(sysDict.getDvalue());
        }
        sysUser.setPasswd(DigestUtil.bcrypt(sysUser.getPasswd()));
        sysUser.setStatus("00");
        sysUser.setUserId(IdUtil.getSnowflakeNextIdStr());
        sysUserMapper.insert(sysUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void edit(SysUserEditResDTO dto) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq(SysUser.COL_USERNAME, dto.getUserName());
        SysUser sysUser = sysUserMapper.selectOne(wrapper);
        if (Objects.isNull(sysUser)) {
            throw new AppException("用户" + dto.getUserName() + "不存在");
        }
        BeanUtil.copyProperties(dto, sysUser);
        if (StrUtil.isNotEmpty(dto.getPasswd())) {
            sysUser.setPasswd(DigestUtil.bcrypt(sysUser.getPasswd()));
        }
        sysUserMapper.updateById(sysUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void changeStatus(SysUserChangeStatusResDTO dto) {
        SysUser sysUser = sysUserMapper.selectById(dto.getUserId());
        if (Objects.isNull(sysUser)) {
            throw new AppException("用户不存在");
        }
        sysUser.setStatus(dto.getStatus());
        sysUserMapper.updateById(sysUser);
    }
}
