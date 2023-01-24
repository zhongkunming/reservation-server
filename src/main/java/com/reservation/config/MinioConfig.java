package com.reservation.config;

import cn.hutool.core.util.StrUtil;
import io.minio.MinioClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Data
@Configuration
public class MinioConfig {

    private static String host;

    private static String ak;

    private static String sk;

    private static String bucket;

    private static MinioClient client;

    @Value("${minio.host}")
    public void setHost(String host) {
        MinioConfig.host = host;

        if (StrUtil.isAllNotEmpty(MinioConfig.host, MinioConfig.ak, MinioConfig.sk, MinioConfig.bucket)) {
            build();
        }
    }

    @Value("${minio.ak}")
    public void setAk(String ak) {
        MinioConfig.ak = ak;

        if (StrUtil.isAllNotEmpty(MinioConfig.host, MinioConfig.ak, MinioConfig.sk, MinioConfig.bucket)) {
            build();
        }
    }

    @Value("${minio.sk}")
    public void setSk(String sk) {
        MinioConfig.sk = sk;

        if (StrUtil.isAllNotEmpty(MinioConfig.host, MinioConfig.ak, MinioConfig.sk, MinioConfig.bucket)) {
            build();
        }
    }

    @Value("${minio.bucket}")
    public void setBucket(String bucket) {
        MinioConfig.bucket = bucket;

        if (StrUtil.isAllNotEmpty(MinioConfig.host, MinioConfig.ak, MinioConfig.sk, MinioConfig.bucket)) {
            build();
        }
    }

    private static void build() {
        if (Objects.isNull(client)) {
            MinioConfig.client = MinioClient.builder()
                    .endpoint(host)
                    .credentials(ak, sk)
                    .build();
        }
    }

    public static String getBucket() {
        return bucket;
    }

    public static MinioClient getClient() {
        return client;
    }
}
