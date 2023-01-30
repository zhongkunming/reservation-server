package com.reservation.service.impl;

import cn.hutool.core.io.IoUtil;
import com.reservation.dto.common.CommonPictureResDTO;
import com.reservation.dto.common.CommonPictureRespDTO;
import com.reservation.exception.AppException;
import com.reservation.model.SysContent;
import com.reservation.model.mapper.SysContentMapper;
import com.reservation.service.CommonService;
import com.reservation.util.MinioUtils;
import io.minio.GetObjectResponse;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommonServiceImpl implements CommonService {

    private final SysContentMapper sysContentMapper;

    @Override
    public CommonPictureRespDTO pictureLink(CommonPictureResDTO dto) {
        String key = dto.getKey();
        SysContent sysContent = sysContentMapper.selectById(key);
        if (Objects.isNull(sysContent)) {
            throw new AppException("文件不存在");
        }
        String link;
        try {
            link = MinioUtils.getShareLink(sysContent.getCid());
        } catch (Exception e) {
            throw new AppException("文件已失效");
        }
        CommonPictureRespDTO respDTO = new CommonPictureRespDTO();
        respDTO.setUrl(link);
        return respDTO;
    }

    @Override
    public void pictureDirect(String key) {
        SysContent sysContent = sysContentMapper.selectById(key);
        if (Objects.isNull(sysContent)) {
            throw new AppException("文件不存在");
        }
        String filename = sysContent.getName();

        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        ServletOutputStream os = null;
        try (GetObjectResponse fis = MinioUtils.downloadFile(sysContent.getCid())) {
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

            response.setHeader("Content-Type", sysContent.getType());
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
