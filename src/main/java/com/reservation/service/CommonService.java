package com.reservation.service;

import com.reservation.dto.common.CommonPictureResDTO;
import com.reservation.dto.common.CommonPictureRespDTO;

public interface CommonService {

    CommonPictureRespDTO picture(CommonPictureResDTO dto);
}
