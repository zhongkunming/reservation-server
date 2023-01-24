package com.reservation.service.impl;

import cn.hutool.core.util.StrUtil;
import com.reservation.dto.common.CommonPictureResDTO;
import com.reservation.dto.common.CommonPictureRespDTO;
import com.reservation.exception.AppException;
import com.reservation.service.CommonService;
import com.reservation.util.MinioUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CommonServiceImpl implements CommonService {

    @Override
    public CommonPictureRespDTO picture(CommonPictureResDTO dto) {
        String key = dto.getKey();
        String profilePicturePrefix = "profile_picture:";
        if (StrUtil.startWith(key, profilePicturePrefix)) {
            key = StrUtil.subAfter(key, profilePicturePrefix, true);
        }
        String link;
        try {
            link = MinioUtils.getShareLink(key);
        } catch (Exception e) {
            throw new AppException("文件已失效");
        }
        CommonPictureRespDTO respDTO = new CommonPictureRespDTO();
        respDTO.setUrl(link);
        return respDTO;
    }


    public static void main(String[] args) {
        String key = "profile_picture1111";

        if (StrUtil.startWith(key, "profile_picture")) {
            key = StrUtil.subAfter(key, "profile_picture", true);
        }
        System.out.println(key);
    }
}
