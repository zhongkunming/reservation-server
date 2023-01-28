package com.reservation.interceptor;

import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.signers.HMacJWTSigner;
import com.github.pagehelper.PageHelper;
import com.reservation.config.JwtConfig;
import com.reservation.exception.AppException;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.Duration;
import java.util.Map;
import java.util.Objects;


@Slf4j
@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final RedissonClient redissonClient;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ContextHolder.clear();
        PageHelper.clearPage();

        String token = request.getHeader(AuthCommons.TOKEN_HEADER);
        if (StrUtil.isEmpty(token)) {
            throw new AppException("Token失效");
        }
        HMacJWTSigner signer = JwtConfig.signer();
        boolean verify = JWTUtil.verify(token, signer);
        if (!verify) {
            throw new AppException("Token失效");
        }

        RBucket<Map<String, Object>> bucket = redissonClient.getBucket(AuthCommons.TOKEN_LOGIN_REDIS_PREFIX + token);
        Map<String, Object> map = bucket.getAndExpire(Duration.ofHours(JwtConfig.getTimeout()));
        if (Objects.isNull(map)) {
            throw new AppException("Token失效");
        }
        ContextHolder.putUserInfo(map);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ContextHolder.clear();
        PageHelper.clearPage();
    }
}
