package com.ustcsse.lottery_system_backend.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by hjw on 2021/4/5 13:41
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {

    private  int id;

    private  String name;

    private Date startTime;

    private Date endTime;
}
