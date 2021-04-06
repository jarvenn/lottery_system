package com.ustcsse.lottery_system_backend.mapper;

import com.ustcsse.lottery_system_backend.model.entity.Prize;
import com.ustcsse.lottery_system_backend.model.entity.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by hjw on 2021/4/5 13:41
 */
public interface PrizeMapper {
    @Select("SELECT * FROM prize")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "leftNum", column = "left_num"),
            @Result(property = "prizeCode", column = "prize_code"),
            @Result(property = "prizeTime", column = "prize_time"),
            @Result(property = "img", column = "img"),
            @Result(property = "gtype", column = "gtype"),
            @Result(property = "activityId", column = "activity_id"),
            @Result(property = "targetOneTime", column = "target_one_time"),
            @Result(property = "value", column = "value")

    })
    public List<Prize> getAll();

    @Select("SELECT * FROM prize WHERE id = #{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "leftNum", column = "left_num"),
            @Result(property = "prizeCode", column = "prize_code"),
            @Result(property = "prizeTime", column = "prize_time"),
            @Result(property = "img", column = "img"),
            @Result(property = "gtype", column = "gtype"),
            @Result(property = "activityId", column = "activity_id"),
            @Result(property = "targetOneTime", column = "target_one_time"),
            @Result(property = "value", column = "value")
    })
    Prize getById(Integer id);

    @Update("UPDATE prize SET left_num=#{leftNum} WHERE id =#{id}")
    void updatePrize(Prize prize);

}
