package com.ustcsse.lottery_system_backend.service.impl;

import com.ustcsse.lottery_system_backend.mapper.LotteryRecordMapper;
import com.ustcsse.lottery_system_backend.mapper.PrizeMapper;
import com.ustcsse.lottery_system_backend.model.entity.LotteryRecord;
import com.ustcsse.lottery_system_backend.model.entity.Prize;
import com.ustcsse.lottery_system_backend.model.entity.User;
import com.ustcsse.lottery_system_backend.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hjw on 2021/4/5 16:25
 */

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    PrizeMapper prizeMapper;

    @Autowired
    LotteryRecordMapper lotteryRecordMapper;

    @Override
    public void insertRecord(User user, Prize prize) {
        lotteryRecordMapper.insertRecord(user,prize);
    }

    @Override
    public boolean checkIfTarget(User user, Prize prize) {
        List<LotteryRecord> list =lotteryRecordMapper.getByUserIdPriceId(user.getId(),prize.getId());
        return list.size()>0;
    }

    @Override
    public List<LotteryRecord> getWiningList() {
        return lotteryRecordMapper.getWingingList();
    }


}
