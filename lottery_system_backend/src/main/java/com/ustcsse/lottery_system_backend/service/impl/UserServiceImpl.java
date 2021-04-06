package com.ustcsse.lottery_system_backend.service.impl;

import com.ustcsse.lottery_system_backend.mapper.UserMapper;
import com.ustcsse.lottery_system_backend.model.entity.User;
import com.ustcsse.lottery_system_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hjw on 2021/4/5 12:20
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        return userMapper.getById(id);
    }

    @Override
    public void updateLotteryTimes(User user) {
        userMapper.updateLotteryTimes(user);
    }

    @Override
    public void donateTimesToUser(User user) {
        userMapper.updateLotteryTimes(user);
    }

    @Override
    public void updateAllLotteryTimes(int lotteryTimes) {
        userMapper.updateAllLotteryTimes(lotteryTimes);
    }


}
