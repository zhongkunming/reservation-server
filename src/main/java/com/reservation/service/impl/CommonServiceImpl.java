package com.reservation.service.impl;

import cn.hutool.core.io.IoUtil;
import com.reservation.dto.common.CommonPictureResDTO;
import com.reservation.dto.common.CommonPictureRespDTO;
import com.reservation.exception.AppException;
import com.reservation.mapper.SysContentMapMapper;
import com.reservation.model.SysContentMap;
import com.reservation.service.CommonService;
import com.reservation.util.MinioUtils;
import io.minio.GetObjectResponse;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Slf4j
@Service
public class CommonServiceImpl implements CommonService {

    private final static String PROFILE_PICTURE_PREFIX = "profile_picture:";

    @Resource
    private SysContentMapMapper sysContentMapMapper;

    @Override
    public CommonPictureRespDTO pictureLink(CommonPictureResDTO dto) {
        String key = dto.getKey();
//        if (StrUtil.startWith(key, PROFILE_PICTURE_PREFIX)) {
//            key = StrUtil.subAfter(key, PROFILE_PICTURE_PREFIX, true);
//        }
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

    @Override
    public void pictureDirect(String key) {

//        if (StrUtil.startWith(key, PROFILE_PICTURE_PREFIX)) {
//            key = StrUtil.subAfter(key, PROFILE_PICTURE_PREFIX, true);
//        }

        SysContentMap sysContentMap = sysContentMapMapper.selectById(key);
        if (Objects.isNull(sysContentMap)) {
            throw new AppException("文件不存在");
        }
        String filename = sysContentMap.getCname();

        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        ServletOutputStream os = null;
        try (GetObjectResponse fis = MinioUtils.downloadFile(key)) {
            HttpServletResponse response = Objects.requireNonNull(sra).getResponse();
            HttpServletRequest request = Objects.requireNonNull(sra).getRequest();

            os = Objects.requireNonNull(response).getOutputStream();

            String userAgent = request.getHeader("User-Agent");
            if (userAgent.toUpperCase().contains("MSIE") || userAgent.contains("Trident/7.0")) {
                filename = URLEncoder.encode(filename, StandardCharsets.UTF_8);
            } else if (userAgent.toUpperCase().contains("MOZILLA") || userAgent.toUpperCase().contains("CHROME")) {
                filename = new String(filename.getBytes(), StandardCharsets.ISO_8859_1);
            } else {
                filename = URLEncoder.encode(filename, StandardCharsets.UTF_8);
            }

            response.setHeader("Content-Type", sysContentMap.getCtype());
            response.setHeader("Content-Length", "-1");
            response.setHeader("Content-Encoding", StandardCharsets.UTF_8.name());
            response.setHeader("Content-Disposition", "attachment;filename=" + filename + "");

            IoUtil.copy(fis, os);
        } catch (Exception e) {
            throw new AppException("文件已失效");
        } finally {
            IoUtil.closeIfPosible(os);
        }
    }
}
