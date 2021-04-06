package com.ustcsse.lottery_system_backend.service;

import com.ustcsse.lottery_system_backend.mapper.UserMapper;
import com.ustcsse.lottery_system_backend.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hjw on 2021/4/5 12:18
 */

public interface UserService {


    public User getUserById(Integer id);

    public void updateLotteryTimes(User user);

    public void donateTimesToUser(User user);

    public void updateAllLotteryTimes(int lotteryTimes);
}
