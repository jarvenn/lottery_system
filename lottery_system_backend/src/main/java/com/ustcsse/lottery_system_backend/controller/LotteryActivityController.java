package com.ustcsse.lottery_system_backend.controller;

import com.ustcsse.lottery_system_backend.model.entity.Activity;
import com.ustcsse.lottery_system_backend.model.entity.LotteryRecord;
import com.ustcsse.lottery_system_backend.model.entity.Prize;
import com.ustcsse.lottery_system_backend.model.entity.User;
import com.ustcsse.lottery_system_backend.service.LotteryActivitiesService;
import com.ustcsse.lottery_system_backend.service.RecordService;
import com.ustcsse.lottery_system_backend.service.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by hjw on 2021/4/5 13:39
 */

@RestController
public class LotteryActivityController {

        @Resource
        private UserService userService;

        @Resource
        private LotteryActivitiesService lotteryActivitiesService;

        @Resource
        private RecordService recordService;


        @RequestMapping("/prizes")
        public List<Prize> prizes(){

            return lotteryActivitiesService.getAllPrizes();
        }

        @RequestMapping(value = "/activity", method = RequestMethod.GET)
        public Activity activity(@RequestParam("id") int id){
            return lotteryActivitiesService.getActivityById(id);
        }

        @RequestMapping("/records")
        public List<LotteryRecord> records(){

            return lotteryActivitiesService.getAllLotteryRecords();
        }

        @RequestMapping("/lottery")
        @Transactional
        public Prize lottery(){

            User user = userService.getUserById(1);

            int lotteryTime = user.getLotteryTimes();
            int permTime = user.getPermTimes();
            if(lotteryTime+permTime<=0){
                return null;
            }

            //???????????????????????????
            //?????????lotteryTimes,lotteryTimesw???0??????permTimes
            if(lotteryTime>0){
                user.setLotteryTimes(lotteryTime-1);
                userService.updateLotteryTimes(user);
            }else{
                user.setPermTimes(permTime-1);
                userService.updateLotteryTimes(user);
            }

            //??????
            Random random = new Random();
            int code = random.nextInt(10000);

            List<Prize> prizeList = lotteryActivitiesService.getAllPrizes();


            System.out.println("code:" + code +  "prizeCode" );

            for(Prize prize : prizeList){
                String[] arr = prize.getPrizeCode().split("-");
                int start = Integer.parseInt(arr[0]);
                int end = Integer.parseInt(arr[1]);
                System.out.println("code:" + code +  "prizeCode:" + prize.getPrizeCode());
                if(code>=start&&code<=end&&prize.getLeftNum()>0){


                    if(!lotteryActivitiesService.checkPropDate(prize)){
                        break;
                    }


                    if(prize.getTargetOneTime() == 0 && recordService.checkIfTarget(user,prize)){
                        System.out.println("????????????????????????????????????");
                        break;
                    }

                    if(prize.getGtype()==0){
                        //???????????????????????????
                        user.setPermTimes(user.getPermTimes()+1);
                        userService.updateLotteryTimes(user);
                        System.out.println("??????????????????");
                    }else{
                        //?????????????????????prize??????????????????
                        prize.setLeftNum(prize.getLeftNum()-1);
                        lotteryActivitiesService.updatePrize(prize);
                        System.out.println("??????????????????");
                    }

                    //????????????????????????
                    recordService.insertRecord(user,prize);

                    return prize;
                }
            }


            //?????????
            System.out.println("??????");
            return null;
        }


}
