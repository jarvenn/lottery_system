package com.ustcsse.lottery_system_backend.service;

import com.sun.org.apache.bcel.internal.generic.LOR;
import com.ustcsse.lottery_system_backend.model.entity.LotteryRecord;
import com.ustcsse.lottery_system_backend.model.entity.Prize;
import com.ustcsse.lottery_system_backend.model.entity.User;

import java.util.List;

/**
 * Created by hjw on 2021/4/5 16:25
 */
public interface RecordService {

    void insertRecord(User user, Prize prize);

    boolean checkIfTarget(User user,Prize prize);

    List<LotteryRecord> getWiningList();
}
