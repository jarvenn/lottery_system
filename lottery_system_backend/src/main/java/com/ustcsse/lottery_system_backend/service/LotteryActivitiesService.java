package com.ustcsse.lottery_system_backend.service;

import com.ustcsse.lottery_system_backend.model.entity.Activity;
import com.ustcsse.lottery_system_backend.model.entity.LotteryRecord;
import com.ustcsse.lottery_system_backend.model.entity.Prize;

import java.util.List;

/**
 * Created by hjw on 2021/4/5 13:54
 */
public interface LotteryActivitiesService {

    public List<Prize> getAllPrizes();

    public Activity getActivityById(int id);

    public List<LotteryRecord> getAllLotteryRecords();

    public Prize getPrizeById(int id);

    public void updatePrize(Prize prize);

    public boolean checkPropDate(Prize prize);
}
