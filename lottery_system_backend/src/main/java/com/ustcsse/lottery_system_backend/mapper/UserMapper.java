package com.ustcsse.lottery_system_backend.mapper;

import com.ustcsse.lottery_system_backend.model.entity.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * Created by hjw on 2021/4/5 12:11
 */


public interface UserMapper {
    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "mobile",column = "mobile"),
            @Result(property = "email",column = "email"),
            @Result(property = "avatar",column = "avatar"),
            @Result(property = "lotteryTimes",column = "lottery_times"),
            @Result(property = "permTimes",column = "perm_times"),
            @Result(property = "sysCreated",column = "sys_created"),
            @Result(property = "sysUpdated",column = "sys_updated")
    })
    User getById(Integer id);

    @Update("UPDATE user SET lottery_times=#{lotteryTimes}, perm_times=#{permTimes} WHERE id =#{id}")
    void updateLotteryTimes(User user);


    @Update("UPDATE user SET lottery_times=#{lotteryTimes}")
    void updateAllLotteryTimes(int lotteryTimes);

}
