package com.ustcsse.lottery_system_backend.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by hjw on 2021/4/5 11:58
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LotteryRecord {
    private int id;

    private int prizeId;

    private int uid;

    private String prizeName;

    private int prizeType;

    private String username;

    private String prizeCode;

    private Date sysCreated;

    private String sysIp;

    private int sysStatus;

    private int prizeValue;

}
