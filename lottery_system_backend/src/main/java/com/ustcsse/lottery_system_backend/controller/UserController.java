package com.ustcsse.lottery_system_backend.controller;

import com.ustcsse.lottery_system_backend.model.entity.User;
import com.ustcsse.lottery_system_backend.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by hjw on 2021/4/5 12:24
 */

@RestController
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public User getUser(@RequestParam(value = "id") int id){
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public void updateUser(){
        User user = userService.getUserById(1);
        user.setLotteryTimes(user.getLotteryTimes()-1);

        userService.updateLotteryTimes(user);
    }

    @RequestMapping("/donate")
    public void donate(@RequestParam("uid") int uid,@RequestParam("num")int num){

        User user = userService.getUserById(uid);
        if(user!=null&&num>0){
            user.setPermTimes(user.getPermTimes()+num);
            userService.updateLotteryTimes(user);
        }

    }
}
