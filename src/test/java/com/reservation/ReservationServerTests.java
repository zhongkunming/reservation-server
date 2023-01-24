package com.reservation;

import com.reservation.config.MinioConfig;
import com.reservation.mapper.SysUserMapper;
import io.minio.GetObjectArgs;
import io.minio.GetObjectResponse;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.PutObjectArgs;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;

@SpringBootTest
class ReservationServerTests {

    @Resource
    private SysUserMapper sysUserMapper;

    @SneakyThrows
    @Test
    void contextLoads() {
        MinioClient client = MinioConfig.getClient();
        File file = new File("/Users/zhongkunming/code/reservation-server/pom.xml");
        FileInputStream fis = new FileInputStream(file);
        ObjectWriteResponse objectWriteResponse = client.putObject(PutObjectArgs.builder().bucket(MinioConfig.getBucket())
                .object("pom.xml").stream(fis, file.length(), -1).build());
        GetObjectResponse object = client.getObject(GetObjectArgs.builder().bucket(MinioConfig.getBucket()).object("pom.xml").build());
        System.out.println();
        client.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder().build());
    }

}
