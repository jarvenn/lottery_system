package com.ustcsse.lottery_system_backend.controller;

import com.ustcsse.lottery_system_backend.model.entity.LotteryRecord;
import com.ustcsse.lottery_system_backend.service.RecordService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hjw on 2021/4/5 21:33
 */

@RestController
public class WiningListController {

    @Resource
    RecordService recordService;

    @RequestMapping("/getWiningList")
    public List<LotteryRecord> getWiningList(){
            return recordService.getWiningList();
    }
}
