package com.reservation.util;

import com.reservation.config.MinioConfig;
import io.minio.GetObjectArgs;
import io.minio.GetObjectResponse;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.http.Method;

import java.util.concurrent.TimeUnit;

public class MinioUtils {

    public static String getShareLink(String key) throws Exception {
        return MinioConfig.getClient().getPresignedObjectUrl(
                GetPresignedObjectUrlArgs
                        .builder()
                        .bucket(MinioConfig.getBucket())
                        .object(key)
                        .method(Method.GET)
                        .expiry(MinioConfig.getTimeout(), TimeUnit.HOURS)
                        .build());
    }

    public static GetObjectResponse downloadFile(String key) throws Exception {
        return MinioConfig.getClient().getObject(
                GetObjectArgs
                        .builder()
                        .bucket(MinioConfig.getBucket())
                        .object(key)
                        .build());


    }
}
