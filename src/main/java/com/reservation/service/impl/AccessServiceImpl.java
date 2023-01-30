package com.reservation.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Maps;
import com.reservation.config.JwtConfig;
import com.reservation.dto.access.AccessLoginResDTO;
import com.reservation.dto.access.AccessLoginRespDTO;
import com.reservation.exception.AppException;
import com.reservation.interceptor.AuthCommons;
import com.reservation.interceptor.ContextHolder;
import com.reservation.model.SysUser;
import com.reservation.model.mapper.SysUserMapper;
import com.reservation.service.AccessService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


@Slf4j
@Service
public class AccessServiceImpl implements AccessService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private RedissonClient redissonClient;

    @Override
    public AccessLoginRespDTO login(AccessLoginResDTO dto) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq(SysUser.COL_ACCOUNT, dto.getAccount());
        SysUser sysUser = sysUserMapper.selectOne(wrapper);

        if (Objects.isNull(sysUser)) {
            throw new AppException("用户不存在");
        }

        boolean flag = DigestUtil.bcryptCheck(dto.getPassword(), sysUser.getPassword());
        if (!flag) {
            throw new AppException("密码错误");
        }

        Map<@Nullable String, @Nullable Object> map = Maps.newHashMap();
        map.put(SysUser.COL_ID, sysUser.getId());
        map.put("login_time", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        String token = JWTUtil.createToken(map, JwtConfig.signer());

        RBucket<Map<String, Object>> bucket = redissonClient.getBucket(AuthCommons.TOKEN_LOGIN_REDIS_PREFIX + token);
        map.put("token", token);
        map.put(SysUser.COL_ACCOUNT, sysUser.getAccount());
        map.put(SysUser.COL_NAME, sysUser.getName());
        map.put(SysUser.COL_PROFILE_PICTURE, sysUser.getProfilePicture());
        map.put(SysUser.COL_EMAIL, sysUser.getEmail());
        bucket.set(map, JwtConfig.getTimeout(), TimeUnit.HOURS);

        AccessLoginRespDTO respDTO = new AccessLoginRespDTO();
        respDTO.setToken(token);

        return respDTO;
    }

    @Override
    public void logout() {
        Map<String, Object> info = ContextHolder.getUserInfo();
        if (Objects.isNull(info)) {
            return;
        }
        String token = (String) info.get("token");
        if (StrUtil.isEmpty(token)) {
            return;
        }
        RBucket<Map<String, Object>> bucket = redissonClient.getBucket(AuthCommons.TOKEN_LOGIN_REDIS_PREFIX + token);
        bucket.delete();
    }

    public static void main(String[] args) {
        System.out.println(DigestUtil.bcrypt("123456"));
    }
}
