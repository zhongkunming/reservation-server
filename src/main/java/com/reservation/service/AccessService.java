package com.reservation.service;

import com.reservation.dto.access.AccessLoginResDTO;
import com.reservation.dto.access.AccessLoginRespDTO;

public interface AccessService {
    AccessLoginRespDTO login(AccessLoginResDTO dto);

    void logout();
}
