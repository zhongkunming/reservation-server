package com.reservation.dto.sys.user;

import com.reservation.dto.BasePageResDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserListResDTO extends BasePageResDTO {

    private String nickName;

    private String status;

    private String userName;
}