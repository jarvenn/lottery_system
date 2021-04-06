package com.ustcsse.lottery_system_backend.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hjw on 2021/4/5 11:48
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private int id;

    private String username;

    private  String password;

    private  String mobile;

    private  String email;

    private  String avatar;

    private  int lotteryTimes;

    private  int permTimes;

    private Date sysCreated;

    private Date sysUpdated;

}
