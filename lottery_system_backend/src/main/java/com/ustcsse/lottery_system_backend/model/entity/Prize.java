package com.ustcsse.lottery_system_backend.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by hjw on 2021/4/5 11:52
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prize {
    private int id;

    private int activityId;

    private  String title;

    private  int leftNum;

    private  String prizeCode;

    private  int prizeTime;

    private  String img;

    private  int gtype;

    private Date sysCreateTime;

    private Date sysUpdateTime;

    private String sysIp;

    private int targetOneTime;

    private int value;
}
