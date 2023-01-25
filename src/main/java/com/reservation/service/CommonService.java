package com.reservation.service;

import com.reservation.dto.common.CommonPictureResDTO;
import com.reservation.dto.common.CommonPictureRespDTO;

public interface CommonService {

    CommonPictureRespDTO pictureLink(CommonPictureResDTO dto);

    void pictureDirect(String key);
}
