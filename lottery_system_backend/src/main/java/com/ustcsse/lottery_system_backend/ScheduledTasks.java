package com.ustcsse.lottery_system_backend;

import com.ustcsse.lottery_system_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by hjw on 2021/4/6 0:00
 * 定时任务
 */

@Component
public class ScheduledTasks {
    @Autowired
    UserService userService;

    private final int INIT_LOTTERY_TIMES = 10;


    //定时任务，每天0点整准时重置每个用户的lottery_times字段为INIT_LOTTERY_TIMES的值
    @Scheduled(cron="0 0 0 * * ?")
    public void refreshUserTimes(){
        userService.updateAllLotteryTimes(INIT_LOTTERY_TIMES);
    }
}
