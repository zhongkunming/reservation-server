package com.reservation.config;


import cn.hutool.jwt.signers.HMacJWTSigner;
import com.reservation.interceptor.AuthCommons;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;


@Data
@Configuration
public class JwtConfig {

    private static String key;

    private static long timeout;

    private static HMacJWTSigner signer;

    @Value("${jwt.key}")
    public void setKey(String key) {
        JwtConfig.key = key;
    }

    @Value("${jwt.timeout}")
    public void setTimeout(long timeout) {
        JwtConfig.timeout = timeout;
    }

    public static String getKey() {
        return key;
    }

    public static long getTimeout() {
        return timeout;
    }

    public static HMacJWTSigner signer() {
        if (Objects.isNull(signer)) {
            signer = new HMacJWTSigner(AuthCommons.TOKEN_ALGORITHM_TYPE, key.getBytes());
        }
        return signer;
    }
}
