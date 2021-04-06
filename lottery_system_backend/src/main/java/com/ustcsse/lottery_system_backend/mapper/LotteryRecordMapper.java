package com.ustcsse.lottery_system_backend.mapper;

import com.ustcsse.lottery_system_backend.model.entity.Activity;
import com.ustcsse.lottery_system_backend.model.entity.LotteryRecord;
import com.ustcsse.lottery_system_backend.model.entity.Prize;
import com.ustcsse.lottery_system_backend.model.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by hjw on 2021/4/5 14:52
 */
public interface LotteryRecordMapper {
    @Select("SELECT * FROM lottery_record")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "prizeId", column = "prize_id"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "prizeName", column = "prize_name"),
            @Result(property = "prizeType", column = "prize_type"),
            @Result(property = "username", column = "username"),
            @Result(property = "prizeCode", column = "prize_code"),
            @Result(property = "prizeValue", column = "prize_value")

    })
    public List<LotteryRecord> getAll();

    @Insert("INSERT INTO lottery_record(prize_id,uid,prize_name,prize_type,username,prize_code,prize_value) " +
            "VALUES(#{prize.id}, #{user.id}, #{prize.title},#{prize.gtype},#{user.username},#{prize.prizeCode},#{prize.value})")
    void insertRecord(User user, Prize prize);


    @Select("SELECT * FROM lottery_record WHERE uid = #{uid} and prize_id =#{prizeId}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "prizeId", column = "prize_id"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "prizeName", column = "prize_name"),
            @Result(property = "prizeType", column = "prize_type"),
            @Result(property = "username", column = "username"),
            @Result(property = "prizeCode", column = "prize_code"),
            @Result(property = "prizeValue", column = "prize_value")
    })
    public List<LotteryRecord> getByUserIdPriceId(int uid,int prizeId);

    @Select("SELECT * FROM lottery_record ORDER BY prize_value DESC LIMIT 10")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "prizeId", column = "prize_id"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "prizeName", column = "prize_name"),
            @Result(property = "prizeType", column = "prize_type"),
            @Result(property = "username", column = "username"),
            @Result(property = "prizeCode", column = "prize_code"),
            @Result(property = "prizeValue", column = "prize_value")
    })
    public List<LotteryRecord> getWingingList();

}
