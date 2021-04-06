package com.ustcsse.lottery_system_backend.service.impl;

import com.ustcsse.lottery_system_backend.mapper.ActivityMapper;
import com.ustcsse.lottery_system_backend.mapper.LotteryRecordMapper;
import com.ustcsse.lottery_system_backend.mapper.PrizeMapper;
import com.ustcsse.lottery_system_backend.model.entity.Activity;
import com.ustcsse.lottery_system_backend.model.entity.LotteryRecord;
import com.ustcsse.lottery_system_backend.model.entity.Prize;
import com.ustcsse.lottery_system_backend.service.LotteryActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by hjw on 2021/4/5 13:55
 */

@Service
public class LotteryActivitiesServiceImpl implements LotteryActivitiesService {

    @Autowired
    PrizeMapper prizeMapper;

    @Autowired
    ActivityMapper activityMapper;

    @Autowired
    LotteryRecordMapper lotteryRecordMapper;

    @Override
    public List<Prize> getAllPrizes() {
        return prizeMapper.getAll();
    }


    @Override
    public Activity getActivityById(int id) {
        return activityMapper.getById(id);
    }

    @Override
    public List<LotteryRecord> getAllLotteryRecords() {
        return lotteryRecordMapper.getAll();
    }

    @Override
    public Prize getPrizeById(int id) {
        return prizeMapper.getById(id);
    }

    @Override
    public void updatePrize(Prize prize) {
        prizeMapper.updatePrize(prize);
    }

    @Override
    public boolean checkPropDate(Prize prize) {

        int activityId = prize.getActivityId();

        Date currenTime = new Date();
//        TimeZone.setDefault(TimeZone.getTimeZone("CTS"));
        Activity activity = activityMapper.getById(activityId);

        System.out.println("当前时间:"+currenTime+"活动开始时间:"+activity.getStartTime()+"活动截止时间:"+activity.getEndTime());
        if(currenTime.compareTo(activity.getStartTime())<0||currenTime.compareTo(activity.getEndTime())>0){
            System.out.println("活动已下架");
            return false;
        }

        return true;
    }


}
