package com.reservation;

import com.reservation.mapper.SysUserMapper;
import com.reservation.model.SysUser;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReservationServerTests {


    @Resource
    private SysUserMapper sysUserMapper;

    @Test
    void contextLoads() {
        SysUser sysUser = sysUserMapper.selectById(1);
        sysUserMapper.insert(sysUser);


    }

}
