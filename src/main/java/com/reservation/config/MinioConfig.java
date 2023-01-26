package com.reservation.config;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Slf4j
@Data
@Configuration
public class MinioConfig {

    private static String host;

    private static String ak;

    private static String sk;

    private static String bucket;

    private static int timeout;

    private static MinioClient client;

    @Value("${minio.host}")
    public void setHost(String host) {
        MinioConfig.host = host;
    }

    @Value("${minio.ak}")
    public void setAk(String ak) {
        MinioConfig.ak = ak;
    }

    @Value("${minio.sk}")
    public void setSk(String sk) {
        MinioConfig.sk = sk;
    }

    @Value("${minio.bucket}")
    public void setBucket(String bucket) {
        MinioConfig.bucket = bucket;
    }

    @Value("${minio.timeout}")
    public void setTimeout(int timeout) {
        MinioConfig.timeout = timeout;
    }

    @PostConstruct
    private static void build() {
        log.info("初始化 minio client");
        if (Objects.isNull(MinioConfig.client)) {
            MinioConfig.client = MinioClient.builder()
                    .endpoint(MinioConfig.host)
                    .credentials(MinioConfig.ak, MinioConfig.sk)
                    .build();
        }
        try {
            log.info("检查bucket -> {} 状态", getBucket());
            boolean flag = getClient().bucketExists(BucketExistsArgs.builder().bucket(getBucket()).build());
            if (!flag) {
                getClient().makeBucket(MakeBucketArgs.builder().bucket(getBucket()).build());
                log.info("bucket -> {} 不存在，重新创建完成", getBucket());
            } else {
                log.info("bucket -> {} 存在", getBucket());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getBucket() {
        return bucket;
    }

    public static MinioClient getClient() {
        return client;
    }

    public static int getTimeout() {
        return timeout;
    }
}
