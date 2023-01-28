package com.reservation.config;

import cn.hutool.extra.spring.EnableSpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@EnableAsync
@Configuration
@EnableScheduling
@EnableSpringUtil
@MapperScan(GlobalAppConfig.MAPPER_SCAN_STRING)
public class GlobalAppConfig {
    public final static String MAPPER_SCAN_STRING = "com.reservation.mapper";

//    @Bean
//    public MybatisPlusInterceptor mybatisPlusInterceptor() {
//        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//        List<InnerInterceptor> interceptors = interceptor.getInterceptors();
//        List<InnerInterceptor> interceptorsNew = Lists.newArrayList(new PaginationInnerInterceptor());
//        interceptorsNew.addAll(interceptors);
//        interceptor.setInterceptors(interceptorsNew);
//        return interceptor;
//    }
}