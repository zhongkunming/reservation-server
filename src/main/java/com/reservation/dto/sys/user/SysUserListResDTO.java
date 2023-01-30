package com.reservation.dto.sys.user;

import com.reservation.dto.BasePageResDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserListResDTO extends BasePageResDTO {

    private String name;

    private String account;

    private String gender;

    private String status;

    private Date regdate;

    private String email;
}