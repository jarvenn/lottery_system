package com.ustcsse.lottery_system_backend.mapper;

import com.ustcsse.lottery_system_backend.model.entity.Activity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * Created by hjw on 2021/4/5 13:40
 */
public interface ActivityMapper {

    @Select("SELECT * FROM activity WHERE id = #{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "startTime", column = "start_time"),
            @Result(property = "endTime", column = "end_time")
    })
    public Activity getById(int id);
}
